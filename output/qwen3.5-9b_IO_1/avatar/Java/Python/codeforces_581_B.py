import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    a = [int(x) for x in input_data[1:n+1]]
    
    dp = [-1] * (n + 1)
    dp[n-1] = a[n-1]
    
    for i in range(n-1, -1, -1):
        dp[i] = max(dp[i+1], a[i])
    
    result = []
    for i in range(n):
        if a[i] > dp[i+1]:
            result.append(0)
        else:
            result.append(dp[i+1] - a[i] + 1)
    
    print(' '.join(map(str, result)))

if __name__ == "__main__":
    main()
