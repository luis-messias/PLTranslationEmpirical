import sys

def main():
    data = sys.stdin.read().split()
    n = int(data[0])
    dp = [0] * 200001
    for i in range(n):
        val = int(data[i + 1])
        dp[val] = i
    ans = 0
    for i in range(2, n + 1):
        ans += abs(dp[i] - dp[i - 1])
    print(ans)

if __name__ == "__main__":
    main()
