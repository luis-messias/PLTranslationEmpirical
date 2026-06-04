#!/usr/bin/env bash
# Full EvalPlus test pipeline: copy translated Java files → Maven build → evaluate.
#
# Usage: bash scripts/test_evalplus_ollama.sh <LABEL> <REPORT_DIR> <ATTEMPT>
#
#   LABEL       : model label used in translate step (= output/<LABEL>/evalplus/Python/Java/)
#   REPORT_DIR  : where to write fix_reports (e.g. fix_reports)
#   ATTEMPT     : 1 for vanilla, 2+ for repair iterations
#
# Examples:
#   bash scripts/test_evalplus_ollama.sh qwen2.5-coder-7b fix_reports 1
#   bash scripts/test_evalplus_ollama.sh qwen2.5-coder-7b_IO_1 fix_reports 2

WORKDIR=$(pwd)
export PYTHONPATH=$WORKDIR
export PYTHONIOENCODING=utf-8

usage() {
    echo
    echo "Syntax: bash scripts/test_evalplus_ollama.sh LABEL REPORT_DIR ATTEMPT"
    echo "  LABEL      : model label matching the translate step (e.g. qwen2.5-coder-7b)"
    echo "  REPORT_DIR : output dir for fix reports (e.g. fix_reports)"
    echo "  ATTEMPT    : attempt number (1 for vanilla, 2 after repair)"
    exit 1
}

while getopts ":h" opt; do
    case $opt in h) usage ;; esac
done

if [[ $# -lt 2 ]]; then
    usage
fi

LABEL=$1
REPORT_DIR=$2
ATTEMPT=$3

TRANSLATED_DIR="output/${LABEL}/evalplus/Python/Java"
MAVEN_MAIN="dataset/evalplus/evalplus_java/src/main/java/com/example"
MAVEN_PROJECT="dataset/evalplus/evalplus_java"

# -- sanity checks ------------------------------------------------------------
if [[ ! -d "$TRANSLATED_DIR" ]]; then
    echo "[test_evalplus_ollama] ERROR: translated output not found at $TRANSLATED_DIR"
    echo "  Run: bash scripts/translate_ollama.sh <TAG> evalplus Python Java 0.2 \"\" 0 \"$LABEL\""
    exit 1
fi

if ! command -v mvn &>/dev/null; then
    echo "[test_evalplus_ollama] ERROR: mvn not found. Install with: sudo apt install maven"
    exit 1
fi

if [[ ! -f "evalplus_target_files.txt" ]]; then
    echo "[test_evalplus_ollama] evalplus_target_files.txt missing — generating it now..."
    ls "$MAVEN_PROJECT/src/test/java/com/example/" \
        | sed 's/Test\.java//' \
        | sort -t_ -k2 -n \
        > evalplus_target_files.txt
    echo "[test_evalplus_ollama] generated evalplus_target_files.txt ($(wc -l < evalplus_target_files.txt) entries)"
fi

# -- step 1: copy translated files into maven src/main ------------------------
echo "[test_evalplus_ollama] step 1: copying $(ls $TRANSLATED_DIR/*.java 2>/dev/null | wc -l) Java files to $MAVEN_MAIN"
rm -f "$MAVEN_MAIN"/*.java
cp "$TRANSLATED_DIR"/*.java "$MAVEN_MAIN"/
echo "[test_evalplus_ollama] copy done"

# -- step 2: run maven --------------------------------------------------------
echo "[test_evalplus_ollama] step 2: running Maven (this may take a few minutes on first run)..."
pushd "$MAVEN_PROJECT" > /dev/null
mvn clean test surefire-report:report -Dmaven.test.failure.ignore=true 2>&1
MVN_EXIT=$?
popd > /dev/null

if [[ $MVN_EXIT -ne 0 ]]; then
    echo "[test_evalplus_ollama] WARNING: Maven compilation failed — filtering broken files and retrying..."
    BROKEN=0
    for f in "$MAVEN_MAIN"/*.java; do
        if ! javac "$f" -d /tmp 2>/dev/null; then
            echo "  removing broken: $(basename $f)"
            rm -f "$f"
            BROKEN=$((BROKEN+1))
        fi
    done
    if [[ $BROKEN -gt 0 ]]; then
        echo "[test_evalplus_ollama] Removed $BROKEN broken file(s). Retrying Maven..."
        pushd "$MAVEN_PROJECT" > /dev/null
        mvn clean test surefire-report:report -Dmaven.test.failure.ignore=true 2>&1
        MVN_EXIT=$?
        popd > /dev/null
    fi
fi
echo "[test_evalplus_ollama] Maven done"

# -- step 3: evaluate surefire reports ----------------------------------------
echo "[test_evalplus_ollama] step 3: evaluating surefire reports..."
mkdir -p "$REPORT_DIR"
python3 src/test/compile_evalplus.py \
    --source_lang Python \
    --target_lang Java \
    --model "$LABEL" \
    --report_dir "$REPORT_DIR" \
    --attempt "$ATTEMPT"

echo "[test_evalplus_ollama] done — results in $REPORT_DIR/${LABEL}_evalplus_errors_from_Python_to_Java_${ATTEMPT}.json"
