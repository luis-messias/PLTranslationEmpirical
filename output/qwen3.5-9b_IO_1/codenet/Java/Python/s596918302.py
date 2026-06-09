import sys

def dpx(arr, n):
    dp = [[0] * 3 for _ in range(n)]
    
    dp[0][0] = arr[0][0]
    dp[0][1] = arr[0][1]
    dp[0][2] = arr[0][2]
    
    for i in range(1, n):
        for in_ in range(3):
            j = 0
            k = 0
            if in_ == 1:
                j = 0
                k = 2
            elif in_ == 0:
                j = 1
                k = 2
            else:
                j = 0
                k = 1
            dp[i][in_] = max(dp[i-1][k], dp[i-1][j]) + arr[i][in_]
    
    return max(dp[n-1][0], max(dp[n-1][1], dp[n-1][2]))

def main():
    n = int(input())
    arr = []
    for _ in range(n):
        row = list(map(int, input().split()))
        arr.append(row)
    
    ans = dpx(arr, n)
    print(ans)

if __name__ == "__main__":
    main()
