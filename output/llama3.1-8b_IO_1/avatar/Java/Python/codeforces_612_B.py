import sys
n = int(input())
dp = [0] * 200001

for _ in range(n):
    idx, val = map(int, input().split())
    dp[idx] = val

ans = 0
for i in range(2, n + 1):
    ans += abs(dp[i] - dp[i-1])

print(ans)
