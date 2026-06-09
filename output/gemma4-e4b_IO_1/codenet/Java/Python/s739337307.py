import sys

def solve():
    # Read all input tokens from standard input
    try:
        input_data = sys.stdin.read().split()
    except Exception:
        return

    if not input_data:
        return

    # N is input_data[0
