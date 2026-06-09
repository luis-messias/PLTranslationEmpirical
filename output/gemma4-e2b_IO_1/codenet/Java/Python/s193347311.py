import sys

def solve():
    # Read all input tokens
    tokens = sys.stdin.read().split()
    
    if not tokens:
        return

    try:
        intLoop = int(tokens[0])
    except ValueError:
        return

    if len(tokens) < 1 + 2 * intLoop:
        return

    intTaro =
