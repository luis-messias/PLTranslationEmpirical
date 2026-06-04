import os
import re
import logging
import argparse
from pathlib import Path
from dotenv import load_dotenv
from tqdm import tqdm
import ollama

os.makedirs('logs', exist_ok=True)
logging.basicConfig(
    filename='logs/translation.log',
    level=logging.INFO,
    format='%(asctime)s %(levelname)s %(module)s - %(funcName)s: %(message)s',
    datefmt='%Y-%m-%d %H:%M:%S',
)

EXTENSIONS = {
    'Python': 'py', 'C': 'c', 'C++': 'cpp',
    'Java': 'java', 'Go': 'go', 'Rust': 'rs', 'C#': 'cs',
}

SYSTEM_PROMPT = (
    "You are a code translation assistant. "
    "When given source code to translate, output ONLY the translated code "
    "inside a single fenced code block (```). "
    "Do not include any explanation, comments about the translation, or text outside the code block."
)


def extract_code(raw: str) -> str:
    """Extract the largest fenced code block; fall back to raw text."""
    blocks = re.findall(r'```[a-zA-Z0-9+#]*\n?(.*?)```', raw, re.DOTALL)
    if blocks:
        return max(blocks, key=len).strip()
    # strip any stray fence markers and return
    return re.sub(r'```[a-zA-Z0-9+#]*', '', raw).replace('```', '').strip()


def clean_translation(code: str, target_lang: str, code_id: str, dataset: str) -> str:
    """Apply post-extraction cleanup identical to translate_gpt4.py."""
    if target_lang == 'Java':
        # consume the class name AND everything else on that line (e.g. the '{', implements, extends)
        # so we don't produce a double-brace like "public class Foo { {"
        code = re.sub(r'public\s*class\s*\S+[^\n]*', 'public class ' + code_id + ' {', code)
    if dataset == 'evalplus' and target_lang == 'Java':
        if 'package com.example;' not in code:
            code = 'package com.example;\n' + code
    return code


def build_prompt(source_lang: str, target_lang: str, code: str) -> str:
    """Vanilla template matching the paper's 'Other models' format (Figure 1)."""
    return (
        f"{source_lang} Code:\n\n{code}\n\n"
        f"Translate the above {source_lang} code to {target_lang}.\n\n"
        f"{target_lang} Code:\n\n"
    )


def translate_file(
    client_model: str,
    source_lang: str,
    target_lang: str,
    dataset: str,
    code_id: str,
    code: str,
    temperature: float,
    top_p: float,
    top_k: int,
    num_ctx: int,
    num_predict: int,
    host: str,
) -> str:
    user_content = build_prompt(source_lang, target_lang, code)
    response = ollama.chat(
        model=client_model,
        messages=[
            {'role': 'system', 'content': SYSTEM_PROMPT},
            {'role': 'user', 'content': user_content},
        ],
        options={
            'temperature': temperature,
            'top_p': top_p,
            'top_k': top_k,
            'num_ctx': num_ctx,
            'num_predict': num_predict,
        },
    )
    raw = response['message']['content']
    code_out = extract_code(raw)
    return clean_translation(code_out, target_lang, code_id, dataset)


def main(args):
    label = args.label or args.model.replace(':', '-').replace('/', '-')
    print(f"[translate_ollama] model={args.model}  label={label}")
    print(f"[translate_ollama] {args.source_lang} -> {args.target_lang}  dataset={args.dataset}")

    in_folder = f'dataset/{args.dataset}/{args.source_lang}/Code'
    out_folder = f'output/{label}/{args.dataset}/{args.source_lang}/{args.target_lang}'
    ext = EXTENSIONS[args.target_lang]

    in_files = sorted(os.listdir(in_folder))
    if args.limit:
        in_files = in_files[:args.limit]

    # resume: skip files already written with non-zero size
    os.makedirs(out_folder, exist_ok=True)
    already_done = set()
    for f in os.listdir(out_folder):
        path = f'{out_folder}/{f}'
        if os.stat(path).st_size > 0:
            already_done.add(f.split('.')[0])

    pending = [f for f in in_files if f.split('.')[0] not in already_done]
    print(f"[translate_ollama] {len(already_done)} already done, {len(pending)} to translate")

    logging.info(
        f"translating {args.source_lang}->{args.target_lang} "
        f"dataset={args.dataset} model={args.model} label={label} "
        f"total={len(in_files)} pending={len(pending)}"
    )

    for fname in tqdm(pending):
        code_id = fname.split('.')[0]
        in_path = f'{in_folder}/{fname}'
        out_path = f'{out_folder}/{code_id}.{ext}'

        try:
            with open(in_path, 'r', encoding='utf-8', errors='ignore') as fh:
                code = fh.read()

            translated = translate_file(
                client_model=args.model,
                source_lang=args.source_lang,
                target_lang=args.target_lang,
                dataset=args.dataset,
                code_id=code_id,
                code=code,
                temperature=args.temperature,
                top_p=args.top_p,
                top_k=args.top_k,
                num_ctx=args.num_ctx,
                num_predict=args.num_predict,
                host=args.host,
            )

            with open(out_path, 'w', encoding='utf-8') as fh:
                fh.write(translated)

        except Exception as e:
            logging.error(f"{fname}: {e}")
            # write a marker so resume logic treats it as done and skips on retry
            with open(out_path, 'w') as fh:
                fh.write(f'# Translation error: {e}\n')

    print(f"[translate_ollama] done. outputs in {out_folder}/")
    print(f"[translate_ollama] use label '{label}' in test/repair scripts")


if __name__ == '__main__':
    load_dotenv()
    parser = argparse.ArgumentParser(
        description='Translate code snippets using a local Ollama model.'
    )
    parser.add_argument('--model', required=True,
                        help='Ollama model tag, e.g. qwen2.5-coder:7b')
    parser.add_argument('--dataset', required=True,
                        help='Dataset name: codenet | avatar | evalplus')
    parser.add_argument('--source_lang', required=True,
                        help='Source language: Python | Java | C | C++ | Go')
    parser.add_argument('--target_lang', required=True,
                        help='Target language: Python | Java | C | C++ | Go')
    parser.add_argument('--temperature', type=float, default=0.2,
                        help='Sampling temperature (default 0.2, matching paper)')
    parser.add_argument('--top_p', type=float, default=0.95,
                        help='Nucleus sampling top-p (default 0.95)')
    parser.add_argument('--top_k', type=int, default=50,
                        help='Top-k sampling (default 50)')
    parser.add_argument('--num_ctx', type=int, default=4096,
                        help='Context window tokens (default 4096)')
    parser.add_argument('--num_predict', type=int, default=2048,
                        help='Max new tokens to generate (default 2048)')
    parser.add_argument('--host', type=str, default='http://localhost:11434',
                        help='Ollama server host (default http://localhost:11434)')
    parser.add_argument('--label', type=str, default='',
                        help='Filesystem-safe output label (default: model tag with : replaced by -)')
    parser.add_argument('--limit', type=int, default=0,
                        help='Translate only the first N files (0 = all; useful for pilot runs)')
    args = parser.parse_args()
    main(args)
