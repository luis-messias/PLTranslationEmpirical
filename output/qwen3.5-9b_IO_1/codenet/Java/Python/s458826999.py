import sys

def main():
    S = input().strip()
    MOD = 1000000007
    dp = [[0] * 13 for _ in range(len(S) + 1)]
    dp[0][0] = 1
    
    for i in range(len(S)):
        if S[i] == '?':
            for j in range(10):
                for k in range(13):
                    new_k = (k * 10 + j) % 13
                    dp[i + 1][new_k] = (dp[i + 1][new_k] + dp[i][k]) % MOD
        else:
            x = int(S[i])
            for k in range(13):
                new_k = (k * 10 + x) % 13
                dp[i + 1][new_k] = (dp[i + 1][new_k] + dp[i][k]) % MOD
    
    print(dp[len(S)][5])

if __name__ == "__main__":
    main()
