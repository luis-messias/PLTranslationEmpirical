n = int(input())
v = [0]
c = input().split()
for i in range(1, n):
    v.append(int(c[i - 1])
dp[0] = 0

 for i in range(1, n + 1): 
 tmp = dp[i - 1] + (v[i - 1] - c[i - 1]) if i > 0 else 0
 dp[i] = max(tmp, dp[i - 1])

tmp = dp[n - 1] + v[-1]
dp[n - 1] = max(dp[n - 1], tmp)

print(dp[n - 1])