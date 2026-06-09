MOD = 1000000007

def solve(input_lines):
    xx = list(map(int, input_lines[0].split()))
    min_val = min(xx)
    max_val = max(xx)

    if min_val == max_val:
        f_min = factorial(min_val) % MOD
        res = (2 * f_min ** 2) % MOD
    elif min_val + 1 == max_val:
        f_min = factorial(min_val) % MOD
        res = (f_min * ((f_min * max_val) % MOD)) % MOD
    else:
        res = 0

    print(res)

def factorial(n):
    result = 1
    for i in range(2, n + 1):
        result *= i
        result %= MOD
    return result


if __name__ == "__main__":
    input_lines = [line.strip() for line in sys.stdin]
    solve(input_lines)