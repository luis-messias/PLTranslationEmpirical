import sys

def main():
    n = int(input())
    v = [0]*n
    c = [0]*n
    dp = [0]*n

    for i in range(n):
        v[i], c[i] = map(int, input().split())

    dp[0] = 0

    for i in range(1, n):
        tmp = dp[i - 1] + (v[i - 1] - c[i - 1])
        dp[i] = max(tmp, dp[i - 1])

    print(dp[n - 1])

if __name__ == "__main__":
    main()
