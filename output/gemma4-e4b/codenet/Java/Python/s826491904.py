import sys

def solve():
    # Read N
    try:
        # Read N from the first line
        N = int(sys.stdin.readline().strip())
    except:
        return

    # Read the first element (initial max and min)
    try:
        line = sys.stdin.readline().strip()
        if not line:
            return
        max_val = min_val = int(line)
    except:
        return

    # Loop N-1 times
    for _ in range(N - 1):
        try:
            line = sys.stdin.readline().strip()
            if not line:
                break
            in_val = int(line)
            max_val = max(max_val, in_val)
            min_val = min(min_val, in_val)
        except:
            break

    print(max_val - min_val)

if __name__ == "__main__":
    solve()