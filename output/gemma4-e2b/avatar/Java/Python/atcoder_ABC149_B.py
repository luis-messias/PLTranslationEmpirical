import sys

def solve():
    # Read A, B, K from a single line of input
    try:
        line = sys.stdin.readline()
        if not line:
            return
        A, B, K = map(int, line.split())
    except EOFError:
        return
    except ValueError:
        # Handle case where input might be malformed, though unlikely in CP context
        return

    # Implementation of calc()
    x = A
    y = B
    x = A - K

    if x < 0:
        y = B + x
        x = 0
        if y < 0:
            y = 0

    # Implementation of showResult()
    print(x, y)

solve()