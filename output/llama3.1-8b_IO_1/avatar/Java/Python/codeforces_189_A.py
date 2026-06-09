import sys

def main():
    input_list = list(map(int, input().split()))
    n = input_list[0]
    a, b, c = input_list[1:4]

    maxn = 4010
    arr = [a, b, c]
    dp = [-float('inf')] * maxn

    for i in range(n):
        dp[i] = -float('inf')

    dp[0] = 0
    for i in range(3):
        for j in range(arr[i], maxn):
            dp[j] = max(dp[j], dp[j - arr[i]] + 1)

    print(dp[n])

if __name__ == "__main__":
    main()
