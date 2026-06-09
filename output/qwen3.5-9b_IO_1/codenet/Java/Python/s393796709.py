MOD = 1000000007

def factorial(n):
    res = 1
    for i in range(2, n + 1):
        res = (res * i) % MOD
    return res

def solve():
    import sys
    line = sys.stdin.readline()
    if line:
        xx = list(map(int, line.split()))
        min_val = min(xx[0], xx[1])
        max_val = max(xx[0], xx[1])
        res = 0
        if min_val == max_val:
            f = factorial(min_val)
            res = (2 * f * f) % MOD
        elif min_val + 1 == max_val:
            f_min = factorial(min_val)
            f_max = factorial(max_val)
            res = (f_min * f_max) % MOD
        print(res)

if __name__ == "__main__":
    solve()
