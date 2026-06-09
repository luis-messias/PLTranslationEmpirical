import sys

MOD = 1000000007
dp = [[0 for _ in range(14)] for __ in range(len(input) + 1)]
dp[0][0] = 1
for i, c in enumerate(input):
    if c == "?":
        for j in range(10):
            for k in range(13):
                dp[i+1][(k * 10 + j) % 13] += dp[i][k]
                dp[i+1][(k * 10 + j) % 13] %= MOD
    else:
        x = int(c)
        for k in range(13):
            dp[i+1][(k * 10 + x) % 13] += dp[i][k]
            dp[i+1][(k * 10 + x) % 13] %= MOD

print(dp[len(input)][5])