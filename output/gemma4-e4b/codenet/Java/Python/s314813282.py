import sys

def solve():
    # Read all inputs from stdin and split them into tokens
    data = sys.stdin.read().split()
    if not data:
        return

    data_iter = iter(data)

    try:
        # 1. Read m, n, x, y
        m = int(next(data_iter))
        n = int(next(data_iter))
        x = int(next(data_iter))
        y = int(next(data_iter))

        # 2. Read array a
        a = []
        for _ in range(m):
            a.append(int(next(data_iter)))

        # 3. Read array b
        b = []
        for _ in range(n):
            b.append(int(next(data_iter)))

    except StopIteration:
        # Handle case where input might be incomplete
        return

    # Calculate x_max
    x_max = max_int(x, a)
    
    # Calculate y_min
    y_min = min_int(y, b)
    
    # Check War
    check_war(x_max, y_min)

def max_int(x, a):
    """Calculates max(x, a[0], a[1], ...)"""
    if not a:
        return x
    return max(x, *a)

def min_int(y, b):
    """Calculates min(y, b[0], b[1], ...)"""
    if not b:
        return y
    return min(y, *b)

def check_war(a, b):
    if a >= b:
        print("War")
    else:
        print("No War")

if __name__ == "__main__":
    solve()