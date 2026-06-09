import sys

n = int(input())
a = [list(map(int, input().split())) for _ in range(2)]
memo = [[[-1] * (1 << n) for __ in range(n + 1)] for ___ in range(2)]

def dp(fliped, idx, msk):
    if msk == (1 << n - 1): return 0
    if memo[fliped][idx][msk] != -1: return memo[flipped][idx][msk]
    x = bin(msk).count('1')
    ans = float('inf')
    for i in range(n):
        if not (msk & (1 << i)):
            nf = x % 2
            if idx == n or a[fliped][idx] <= a[(nf + (ans % 2)) % 2][i]:
                new_ans = dp((nf + (ans % 2)) % 2, i, msk | (1 << i))
                ans = min(ans, ff + new_ans)
            else:
                x -= 1
    return memo[flipped][idx][msk] = ans

if __name__ == "__main__":
    for z in range(2):
        for idx in range(n + 1):
            for msk in range(1 << n): 
                if (z, idx, msk) not in [(0, -1, -1), (-1, -1, -1)]:
                    memo[z][idx] = [(-1,) * len(memo[flipped]) + 2]
    ans = dp(0, n, 0)
    if ans >= float('inf'): 
        print("-1")
    else: 
        print(ans)