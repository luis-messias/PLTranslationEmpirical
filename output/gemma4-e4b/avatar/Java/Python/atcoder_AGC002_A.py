import sys

def solve():
    try:
        # Read all inputs from stdin
        data = sys.stdin.read().split()
        if not data:
            return

        a = int(data[0])
        b = int(data[1])

        if a > 0:
            print("Positive")
        elif b >= 0:
            print("Zero")
        elif (b - a + 1) % 2 == 0:
            print("Positive")
        else:
            print("Negative")

    except EOFError:
        pass
    except Exception:
        pass

solve()