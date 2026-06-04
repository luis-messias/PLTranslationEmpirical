#!/usr/bin/env bash
# Usage: bash scripts/repair_ollama.sh <OLLAMA_TAG> <LABEL> <DATASET> <SRC> <TGT> <ATTEMPT> <ERROR_TYPE> [TEMPERATURE]
#
# LABEL must match the label used during translate_ollama.sh (same as --label / output dir key).
# ERROR_TYPE: compile | runtime | incorrect
#
# Examples:
#   bash scripts/repair_ollama.sh qwen2.5-coder:7b qwen2.5-coder-7b codenet Java Python 1 compile
#   bash scripts/repair_ollama.sh qwen2.5-coder:7b qwen2.5-coder-7b codenet Java Python 1 runtime 0.2

WORKDIR=$(pwd)
export PYTHONPATH=$WORKDIR
export PYTHONIOENCODING=utf-8

usage() {
    echo
    echo "Syntax: bash scripts/repair_ollama.sh OLLAMA_TAG LABEL DATASET SRC_LANG TGT_LANG ATTEMPT ERROR_TYPE [TEMPERATURE]"
    echo "  OLLAMA_TAG   : Ollama model tag, e.g. qwen2.5-coder:7b"
    echo "  LABEL        : filesystem label used in translate step (= output/<LABEL>/...)"
    echo "  DATASET      : codenet | avatar | evalplus"
    echo "  SRC_LANG     : Python | Java | C | C++ | Go"
    echo "  TGT_LANG     : Python | Java | C | C++ | Go"
    echo "  ATTEMPT      : repair iteration number (1, 2, ...)"
    echo "  ERROR_TYPE   : compile | runtime | incorrect"
    echo "  TEMPERATURE  : (optional, default 0.2)"
    exit 1
}

while getopts ":h" opt; do
    case $opt in h) usage ;; esac
done

if [[ $# -lt 7 ]]; then
    usage
fi

MODEL_TAG=$1
LABEL=$2
DATASET=$3
SRC=$4
TGT=$5
ATTEMPT=$6
ERROR_TYPE=$7
TEMPERATURE=${8:-0.2}

python3 src/translation/repair.py \
    --model "$LABEL" \
    --ollama_model "$MODEL_TAG" \
    --dataset "$DATASET" \
    --source_lang "$SRC" \
    --target_lang "$TGT" \
    --k 50 \
    --p 0.95 \
    --temperature "$TEMPERATURE" \
    --gpu_id 0 \
    --attempt "$ATTEMPT" \
    --error_type "$ERROR_TYPE"
