import sys

def main():
    input_data = sys.stdin.read().split()
    v1 = int(input_data[0])
    v2 = int(input_data[1])
    t = int(input_data[2])
    d = int(input_data[3])
    
    dp = [[-(10**17)] * 1150 for _ in range(t - 1)]
    
    dp[0][v1] = v1
    
    for i in range(1, t - 1):
        for j in range(1150):
            for x in range(d + 1):
                if j + x < 1150:
                    dp[i][j] = max(dp[i][j], dp[i - 1][j + x] + j)
            for x in range(d, -1, -1):
                if j - x >= 0:
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - x] + j)
    
    ans = -(10**18)
    for j in range(1150):
        if abs(j - v2) <= d:
            ans = max(ans, dp[t - 2][j] + v2)
    
    print(ans)

if __name__ == "__main__":
    main()
