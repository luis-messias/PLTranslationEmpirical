import sys

def solve():
    # Read a, b, t from standard input
    try:
        # Read inputs sequentially
        a = int(sys.stdin.readline())
        b = int(sys.stdin.readline())
        t = int(sys.stdin.readline())
    except:
        # Handle case where input might be missing or invalid
        return

    time = 0.0
    count = 0
    T_limit = t + 0.5

    while time < T_limit:
        count += b
        time += a
        
        if time > T_limit:
            count -= b
            break

    print(count)

solve()