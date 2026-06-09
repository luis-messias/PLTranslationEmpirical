import sys
from io import StringIO

memo = None
a = None
n = 0

def dp(fliped, idx, msk):
    global memo, a, n
    if msk == (1 << n) - 1:
        return 0
    if memo[fliped][idx][msk] != -1:
        return memo[fliped][idx][msk]
    
    x = bin(msk).count('1')
    ff = 0
    ans = 10**9
    
    for i in range(n):
        if (msk & (1 << i)) == 0:
            nf = x % 2
            if idx == n or a[fliped][idx] <= a[(nf + (ff % 2)) % 2][i]:
                ans = min(ans, ff + dp((nf + (ff % 2)) % 2, i, msk | (1 << i)))
            ff += 1
        else:
            x -= 1
    
    memo[fliped][idx][msk] = ans
    return ans

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    iterator = iter(input_data)
    n = int(next(iterator))
    a = [[0] * n for _ in range(2)]
    for i in range(n):
        a[0][i] = int(next(iterator))
    for i in range(n):
        a[1][i] = int(next(iterator))
    
    memo = [[[-1] * (1 << n) for _ in range(n + 1)] for _ in range(2)]
    ans = dp(0, n, 0)
    print(ans if ans < 10**8 else -1)

if __name__ == "__main__":
    main()
