import sys

def solve():
    try:
        # Read n and m from standard input
        data = sys.stdin.read().split()
        if not data:
            return
        
        n = int(data[0])
        m = int(data[1])
    except Exception:
        # Handle case where input might be missing or invalid, though typically competitive programming inputs are guaranteed.
        return

    if n == 0:
        if m != 0:
            print("Impossible")
        else:
            print("0 0")
    else:
        if m <= n:
            if m == 0:
                m = 1
            # Output n and m + n - 1
            print(f"{n} {m + n - 1}")
        else:
            # Output m and m + n - 1
            print(f"{m} {m + n - 1}")

solve()