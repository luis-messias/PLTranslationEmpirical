import sys

def solve():
    try:
        # Read the entire line from standard input
        line = sys.stdin.readline().strip()
        if not line:
            return

        # Split the line and map to integers
        a, b = map(int, line.split())

        # Calculate c
        c = a - b * 2

        # Clamp c to be non-negative (equivalent to if (c < 0) c = 0)
        result = max(0, c)

        print(result)

    except Exception:
        # Catching exceptions to mimic the Java try-catch block
        pass

if __name__ == "__main__":
    solve()