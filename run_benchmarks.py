#!/usr/bin/env python3
"""
run_benchmarks.py — Orchestrate the "Lost in Translation" replication pipeline.

Runs all models on one benchmark before moving to the next.
Skips stages that are already done (translate / test / repair / retest).

Usage:
  python3 run_benchmarks.py                          # show status table only
  python3 run_benchmarks.py --run                    # run all pending jobs
  python3 run_benchmarks.py --run --dry-run          # show plan without executing
  python3 run_benchmarks.py --run --limit 25         # cap snippets per job
  python3 run_benchmarks.py --models qwen2.5-coder:7b llama3.1:8b
  python3 run_benchmarks.py --benchmarks codenet avatar
  python3 run_benchmarks.py --clean                  # wipe artefacts (with confirmation)
  python3 run_benchmarks.py --clean --run            # clean then run
"""

import argparse
import json
import logging
import shutil
import subprocess
from dataclasses import dataclass
from pathlib import Path
from typing import Optional

from rich.console import Console
from rich.table import Table
from rich import box
from rich.text import Text
from rich.panel import Panel

# ---------------------------------------------------------------------------
# Configuration
# ---------------------------------------------------------------------------

REPO_ROOT = Path(__file__).parent.resolve()
FIX_REPORTS = REPO_ROOT / "fix_reports"
OUTPUT_DIR = REPO_ROOT / "output"
LOGS_DIR = REPO_ROOT / "logs"

# Dataset sizes (total snippets in each source language directory)
# _CODENET = {
#     "C": 200, "C++": 200, "Go": 200, "Java": 201, "Python": 200,
# }
_CODENET = {
    "Java": 201, "Python": 200,
}

DATASET_SIZES = {
    # CodeNet — all 20 pairs among C / C++ / Go / Java / Python
    **{("codenet", src, tgt): _CODENET[src]
       for src in _CODENET for tgt in _CODENET if src != tgt},
    # AVATAR — Java↔Python only
    ("avatar",  "Java",   "Python"): 249,
    ("avatar",  "Python", "Java"):   250,
    # EvalPlus — Python→Java only
    ("evalplus","Python", "Java"):   164,
}

# _LANGS = ["C", "C++", "Go", "Java", "Python"]
_LANGS = ["Java", "Python"]

# Ordered: benchmark-first execution
ALL_BENCHMARKS = (
    # CodeNet — all 20 pairs, grouped by source language
    [("codenet", src, tgt) for src in _LANGS for tgt in _LANGS if src != tgt]
    + [
        ("avatar",  "Java",   "Python"),
        ("avatar",  "Python", "Java"),
        ("evalplus","Python", "Java"),
    ]
)

DEFAULT_MODELS = [
    "gemma4:e2b",
    "phi4-mini:3.8b",
    "gemma4:e4b",
    "llama3.1:8b",
    "qwen3.5:9b",
    "starcoder2:7b"
]

console = Console()

# ---------------------------------------------------------------------------
# Helpers
# ---------------------------------------------------------------------------

def label_for(model_tag: str) -> str:
    return model_tag.replace(":", "-").replace("/", "-")


def installed_models() -> set[str]:
    try:
        out = subprocess.check_output(["ollama", "list"], text=True)
        tags = set()
        for line in out.splitlines()[1:]:
            parts = line.split()
            if parts:
                tags.add(parts[0])
        return tags
    except Exception:
        return set()


def count_output_files(label: str, dataset: str, src: str, tgt: str) -> int:
    d = OUTPUT_DIR / label / dataset / src / tgt
    if not d.exists():
        return 0
    return sum(1 for f in d.iterdir() if f.is_file() and f.stat().st_size > 0)


def errors_json_path(label: str, dataset: str, src: str, tgt: str, attempt: int) -> Path:
    return FIX_REPORTS / f"{label}_{dataset}_errors_from_{src}_to_{tgt}_{attempt}.json"


def repair_output_count(label: str, dataset: str, src: str, tgt: str) -> int:
    return count_output_files(f"{label}_IO_1", dataset, src, tgt)


def errors_in_json(path: Path) -> int:
    """Total number of failures in a fix_reports JSON."""
    if not path.exists():
        return -1
    try:
        with open(path) as f:
            d = json.load(f)
        return sum(len(v) for v in d.values())
    except Exception:
        return -1


# ---------------------------------------------------------------------------
# Stage detection
# ---------------------------------------------------------------------------

@dataclass
class StageStatus:
    translate: str = "pending"   # pending / done / failed
    test:      str = "pending"
    repair:    str = "pending"
    retest:    str = "pending"


def job_status(label: str, dataset: str, src: str, tgt: str, limit: int) -> StageStatus:
    s = StageStatus()
    total = DATASET_SIZES.get((dataset, src, tgt), 0)
    expected = min(limit, total) if limit > 0 else total

    # test (errors JSON for attempt 1 exists)
    errors1 = errors_json_path(label, dataset, src, tgt, 1)
    if errors1.exists():
        s.test = "done"

    # translate — done if file count is sufficient OR if test already ran
    # (test can't exist without translate having completed for those files)
    n = count_output_files(label, dataset, src, tgt)
    if n >= expected or s.test == "done":
        s.translate = "done"

    # repair (output dir for _IO_1 has files)
    if repair_output_count(label, dataset, src, tgt) > 0:
        s.repair = "done"

    # retest (errors JSON for attempt 2 exists, keyed under IO_1 label)
    errors2 = errors_json_path(f"{label}_IO_1", dataset, src, tgt, 2)
    if errors2.exists():
        s.retest = "done"

    return s


# ---------------------------------------------------------------------------
# Status table
# ---------------------------------------------------------------------------

STAGE_ICONS = {
    "done":    "[green]✓[/]",
    "pending": "[dim]○[/]",
    "running": "[yellow]▶[/]",
    "failed":  "[red]✗[/]",
    "skip":    "[dim]-[/]",
}


def cell_text(st: StageStatus) -> Text:
    parts = [
        f"T:{STAGE_ICONS[st.translate]}",
        f"E:{STAGE_ICONS[st.test]}",
        f"R:{STAGE_ICONS[st.repair]}",
        f"R2:{STAGE_ICONS[st.retest]}",
    ]
    return Text.from_markup("  ".join(parts))


def make_status_table(models: list[str], benchmarks: list[tuple],
                      limit: int, current_job: Optional[tuple] = None) -> Table:
    table = Table(box=box.ROUNDED, show_header=True, header_style="bold cyan")
    table.add_column("Benchmark / Pair", style="bold", min_width=22)
    for m in models:
        table.add_column(m, min_width=22)

    for (dataset, src, tgt) in benchmarks:
        row_label = f"[bold]{dataset.upper()}[/]  {src}→{tgt}"
        cells = []
        for m in models:
            lbl = label_for(m)
            st = job_status(lbl, dataset, src, tgt, limit)
            # mark currently-running job
            if current_job and current_job == (m, dataset, src, tgt):
                text = Text.from_markup("[yellow]▶ running…[/]")
            else:
                text = cell_text(st)
            cells.append(text)
        table.add_row(row_label, *cells)

    return table


def print_status(models, benchmarks, limit, current_job=None):
    table = make_status_table(models, benchmarks, limit, current_job)
    legend = "[dim]T=translate  E=eval/test  R=repair  R2=retest  [green]✓[/]=done  [dim]○[/]=pending  [red]✗[/]=failed[/]"
    console.print()
    console.print(Panel(table, title="[bold]Lost in Translation — Benchmark Status[/]",
                        subtitle=legend, border_style="cyan"))
    console.print()


# ---------------------------------------------------------------------------
# Job execution
# ---------------------------------------------------------------------------

def setup_logging():
    LOGS_DIR.mkdir(exist_ok=True)
    logging.basicConfig(
        filename=str(LOGS_DIR / "orchestrator.log"),
        level=logging.INFO,
        format="%(asctime)s %(levelname)s %(message)s",
        datefmt="%Y-%m-%d %H:%M:%S",
    )


def run_cmd(cmd: list[str], description: str, dry_run: bool) -> bool:
    """Run a subprocess. Returns True on success."""
    cmd_str = " ".join(cmd)
    console.print(f"  [cyan]▶[/] {description}")
    logging.info("RUN: %s", cmd_str)

    if dry_run:
        console.print(f"    [dim](dry-run) {cmd_str}[/]")
        return True

    result = subprocess.run(cmd, cwd=str(REPO_ROOT),
                            capture_output=False)
    if result.returncode != 0:
        console.print(f"  [red]✗ failed (exit {result.returncode})[/]")
        logging.error("FAILED (%d): %s", result.returncode, cmd_str)
        return False

    console.print(f"  [green]✓ done[/]")
    return True


def run_job(model: str, dataset: str, src: str, tgt: str,
            limit: int, dry_run: bool, models: list, benchmarks: list) -> None:
    lbl = label_for(model)
    st = job_status(lbl, dataset, src, tgt, limit)
    total = DATASET_SIZES.get((dataset, src, tgt), 0)
    expected = min(limit, total) if limit > 0 else total

    console.rule(f"[bold cyan]{model}  {dataset.upper()} {src}→{tgt}[/]")
    print_status(models, benchmarks, limit, current_job=(model, dataset, src, tgt))

    # 1. Translate
    if st.translate != "done":
        ok = run_cmd(
            ["bash", "scripts/translate_ollama.sh",
             model, dataset, src, tgt, "0.2", "", str(limit)],
            f"Translate {src}→{tgt} ({expected} snippets)",
            dry_run,
        )
        if not ok:
            return
    else:
        console.print(f"  [dim]skip translate (already done)[/]")

    # 2. Test
    if st.test != "done":
        if dataset == "evalplus":
            ok = run_cmd(
                ["bash", "scripts/test_evalplus_ollama.sh", lbl, "fix_reports", "1"],
                "Evaluate translations (Maven + surefire)",
                dry_run,
            )
        else:
            ok = run_cmd(
                ["bash", f"scripts/test_{dataset}.sh", src, tgt, lbl, "fix_reports", "1"],
                "Evaluate translations",
                dry_run,
            )
        if not ok:
            return
        st.test = "done"
    else:
        console.print(f"  [dim]skip test (already done)[/]")

    # 3. Repair (skip if test never ran or all translations passed)
    if st.test != "done":
        console.print(f"  [dim]skip repair (test not done)[/]")
        return
    if st.repair != "done":
        errors1 = errors_json_path(lbl, dataset, src, tgt, 1)
        error_counts = {}
        if errors1.exists():
            try:
                with open(errors1) as f:
                    d = json.load(f)
                error_counts = {k: len(v) for k, v in d.items()}
            except Exception:
                error_counts = {}

        ran_any = False
        for error_type in ["compile", "runtime", "incorrect"]:
            if error_counts.get(error_type, 1) == 0:
                console.print(f"  [dim]skip repair/{error_type} (0 failures)[/]")
                continue
            ok = run_cmd(
                ["bash", "scripts/repair_ollama.sh",
                 model, lbl, dataset, src, tgt, "1", error_type],
                f"Repair {error_type} errors",
                dry_run,
            )
            ran_any = True
            if not ok:
                console.print(f"  [yellow]repair/{error_type} failed, continuing[/]")
        if not ran_any:
            console.print(f"  [dim]skip repair (no failures to fix)[/]")
    else:
        console.print(f"  [dim]skip repair (already done)[/]")

    # 4. Retest
    if st.retest != "done":
        repair_lbl = f"{lbl}_IO_1"
        if repair_output_count(lbl, dataset, src, tgt) == 0 and not dry_run:
            console.print(f"  [dim]skip retest (no repaired files)[/]")
        else:
            if dataset == "evalplus":
                ok = run_cmd(
                    ["bash", "scripts/test_evalplus_ollama.sh",
                     repair_lbl, "fix_reports", "2"],
                    "Re-evaluate repaired translations",
                    dry_run,
                )
            else:
                ok = run_cmd(
                    ["bash", f"scripts/test_{dataset}.sh",
                     src, tgt, repair_lbl, "fix_reports", "2"],
                    "Re-evaluate repaired translations",
                    dry_run,
                )
    else:
        console.print(f"  [dim]skip retest (already done)[/]")


# ---------------------------------------------------------------------------
# Clean
# ---------------------------------------------------------------------------

def do_clean(models: list[str], dry_run: bool) -> None:
    labels = [label_for(m) for m in models]
    dirs_to_rm = []
    files_to_rm = []

    for lbl in labels:
        d = OUTPUT_DIR / lbl
        if d.exists():
            dirs_to_rm.append(d)
        repair_d = OUTPUT_DIR / f"{lbl}_IO_1"
        if repair_d.exists():
            dirs_to_rm.append(repair_d)

    if FIX_REPORTS.exists():
        for lbl in labels:
            files_to_rm.extend(FIX_REPORTS.glob(f"{lbl}_*"))
            files_to_rm.extend(FIX_REPORTS.glob(f"{lbl}_IO_1_*"))

    if not dirs_to_rm and not files_to_rm:
        console.print("[dim]Nothing to clean.[/]")
        return

    console.print(f"\n[bold red]Clean will delete:[/]")
    for d in dirs_to_rm:
        console.print(f"  [red]dir [/] {d}")
    for f in files_to_rm:
        console.print(f"  [red]file[/] {f}")

    if dry_run:
        console.print("[dim](dry-run — nothing deleted)[/]")
        return

    answer = input(f"\nDelete {len(dirs_to_rm)} directories and {len(files_to_rm)} files? [y/N] ")
    if answer.strip().lower() != "y":
        console.print("[yellow]Aborted.[/]")
        return

    for d in dirs_to_rm:
        shutil.rmtree(d)
        logging.info("CLEAN dir: %s", d)
    for f in files_to_rm:
        f.unlink()
        logging.info("CLEAN file: %s", f)

    console.print(f"[green]Cleaned {len(dirs_to_rm)} dirs and {len(files_to_rm)} files.[/]")


# ---------------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------------

def main():
    parser = argparse.ArgumentParser(
        description="Orchestrate the Lost-in-Translation replication pipeline."
    )
    parser.add_argument("--run", action="store_true",
                        help="Execute pending jobs (default: show status only)")
    parser.add_argument("--dry-run", action="store_true",
                        help="Show what would run without executing")
    parser.add_argument("--clean", action="store_true",
                        help="Delete output artefacts for configured models (with confirmation)")
    parser.add_argument("--limit", type=int, default=0,
                        help="Translate only first N files per job (0 = all)")
    parser.add_argument("--models", nargs="+", default=DEFAULT_MODELS,
                        help="Models to run (Ollama tags)")
    parser.add_argument("--benchmarks", nargs="+",
                        choices=sorted({d for d, _, _ in ALL_BENCHMARKS}),
                        help="Restrict to these benchmarks")
    args = parser.parse_args()

    setup_logging()

    # Filter benchmarks
    benchmarks = ALL_BENCHMARKS
    if args.benchmarks:
        benchmarks = [(d, s, t) for (d, s, t) in ALL_BENCHMARKS if d in args.benchmarks]

    models = args.models

    # Check which models are not yet pulled
    installed = installed_models()
    missing = [m for m in models if m not in installed]
    if missing:
        console.print("[yellow]Warning:[/] these models are not installed:")
        for m in missing:
            console.print(f"  [yellow]ollama pull {m}[/]")
        console.print()

    # Clean
    if args.clean:
        do_clean(models, dry_run=args.dry_run)

    # Status table (always shown)
    print_status(models, benchmarks, args.limit)

    if not args.run:
        return

    # Run jobs: model-first ordering (all benchmarks for one model, then next model)
    for model in models:
        if model in missing:
            console.print(f"[yellow]Skipping {model} — not installed[/]")
            continue
        for (dataset, src, tgt) in benchmarks:
            run_job(model, dataset, src, tgt,
                    limit=args.limit,
                    dry_run=args.dry_run,
                    models=models,
                    benchmarks=benchmarks)

    # Final status
    console.rule("[bold green]All jobs complete[/]")
    print_status(models, benchmarks, args.limit)
    logging.info("Orchestration run complete.")


if __name__ == "__main__":
    main()
