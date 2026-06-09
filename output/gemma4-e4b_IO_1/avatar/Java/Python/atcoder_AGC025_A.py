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
        # Reading all input and stripping whitespace is robust for single integer input
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        N = int(input_data)
    except Exception:
        return

    # Calculate n: n = ceil(N / 2)
    # This is equivalent to (N + 1) // 2
    n = (N + 1) // 2

    # Initialize ans = sum(1) + sum(N - 1)
    ans = sum_digits(1) + sum_digits(N - 1)

    # Iterate A from 1 to n (inclusive)
    for A in range(1, n + 1):
        current_sum = sum_digits(A) + sum_digits(N - A)
        if current_sum < ans:
            ans = current_sum

    print(ans)

if __name__ == "__main__":
    solve()
