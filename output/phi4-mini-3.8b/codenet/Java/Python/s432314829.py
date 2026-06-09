import sys

n, m = map(int, input().split())
dp = [0] * (n + 1)
dp[n - 1], dp[n] = 1, 0
for _ in range(m):
    x = int(input())
    if 0 <= x < n:
        dp[x] = -1

for i in range(n - 2, -1, -1):
    if dp[i + 1] == -1 and not (i + 3 >= len(dp)):
        continue
    else:
        dp[i] = sum([dp[j] for j in [i + 1, i + 2]]) % 1000000007

print(dp[0])