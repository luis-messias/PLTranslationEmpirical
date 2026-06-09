import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    a = int(input_data[1])
    b = int(input_data[2])
    c = int(input_data[3])
    
    arr = [a, b, c]
    maxn = 4010
    dp = [float('-inf')] * maxn
    dp[0] = 0
    
    for i in range(3):
        for j in range(arr[i], maxn):
            dp[j] = max(dp[j], dp[j - arr[i]] + 1)
    
    print(dp[n])

if __name__ == "__main__":
    main()
