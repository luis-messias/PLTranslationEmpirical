import sys

def main():
    v1, v2, t, d = map(int, input().split())
    dp = [[-10**17 for _ in range(1150)] for _ in range(t - 1)]
    dp[0][v1] = v1
    sum = 0
    for i in range(1, t - 1):
        for j in range(1150):
            for x in range(d + 1):
                if j + x < 1150:
                    dp[i][j] = max(dp[i][j], dp[i-1][j+x] + j)
            for x in range(d, -1, -1):
                if j - x >= 0:
                    dp[i][j] = max(dp[i][j], dp[i-1][j-x] + j)
    ans = -10**17
    for i in range(t - 2, t - 1):
        for j in range(1150):
            if abs(j - v2) <= d:
                ans = max(ans, dp[i][j] + v2)
    print(ans)

if __name__ == "__main__":
    main()
