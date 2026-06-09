MOD = 998244353
dp = [[0] * 3001 for _ in range(3001)]

def solve(sc):
    A, B, C, D = map(int, sc.readline().split())
    dp[A][B] = 1
    for c in range(A, C + 1):
        for d in range(B, D + 1):
            if c == A and d == B:
                continue
            ans = 0
            if c > A:
                part = dp[c - 1][d]
                ans += part * d
            if d > B:
                part = dp[c][d - 1]
                ans += part * c
            if c > A and d > B:
                ans -= dp[c - 1][d - 1] * (c - 1) * (d - 1)
            dp[c][d] = (ans % MOD + MOD) % MOD
    print(dp[C][D])

import sys

sc = open("input.txt", "r")
pw = open("output.txt", "w")

solve(sc)

sc.close()
pw.close()