import sys

def solve():
    # Read the input string S
    try:
        S = sys.stdin.read().strip()
    except:
        # Handle case where input might be empty or error during reading
        return

    if not S:
        return

    MOD = 1000