#!/usr/bin/env bash
# Usage: bash scripts/translate_ollama.sh <OLLAMA_TAG> <DATASET> <SRC_LANG> <TGT_LANG> [TEMPERATURE] [LABEL] [LIMIT]
#
# Examples:
#   bash scripts/translate_ollama.sh qwen2.5-coder:7b codenet Java Python
#   bash scripts/translate_ollama.sh qwen2.5-coder:7b codenet Java Python 0.2 qwen2.5-coder-7b 25

WORKDIR=$(pwd)
export PYTHONPATH=$WORKDIR
export PYTHONIOENCODING=utf-8

usage() {
    echo
    echo "Syntax: bash scripts/translate_ollama.sh OLLAMA_TAG DATASET SRC_LANG TGT_LANG [TEMPERATURE] [LABEL] [LIMIT]"
    echo "  OLLAMA_TAG   : Ollama model tag, e.g. qwen2.5-coder:7b"
    echo "  DATASET      : codenet | avatar | evalplus"
    echo "  SRC_LANG     : Python | Java | C | C++ | Go"
    echo "  TGT_LANG     : Python | Java | C | C++ | Go"
    echo "  TEMPERATURE  : (optional, default 0.2)"
    echo "  LABEL        : (optional, default = tag with ':' replaced by '-')"
    echo "  LIMIT        : (optional, translate only first N files; 0 = all)"
    exit 1
}

while getopts ":h" opt; do
    case $opt in h) usage ;; esac
done

if [[ $# -lt 4 ]]; then
    usage
fi

MODEL=$1
DATASET=$2
SRC=$3
TGT=$4
TEMPERATURE=${5:-0.2}
LABEL=${6:-""}
LIMIT=${7:-0}

LABEL_ARG=""
if [[ -n "$LABEL" ]]; then
    LABEL_ARG="--label $LABEL"
fi

python3 src/translation/translate_ollama.py \
    --model "$MODEL" \
    --dataset "$DATASET" \
    --source_lang "$SRC" \
    --target_lang "$TGT" \
    --temperature "$TEMPERATURE" \
    --limit "$LIMIT" \
    $LABEL_ARG
