def sum_digits(a):
    s = 0
    while a > 0:
        s += a % 10
        a //= 10
    return s

def solve():
    import sys
    # Read N from standard input
    try:
        N = int(sys.stdin.read().strip())
    except:
        return

    # Calculate n: n = ceil(N / 2)
    n = (N + 1) // 2

    # Initialize ans = sum(1) + sum(N - 1)
    ans = sum_digits(1