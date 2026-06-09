import sys

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    N = int(next(iterator))
    T = int(next(iterator))
    
    AB = []
    for _ in range(N):
        AB.append([int(next(iterator)), int(next(iterator))])
    
    AB.sort(key=lambda x: x[0])
    
    dp = [[0] * 6001 for _ in range(N + 1)]
    
    for i in range(1, N + 1):
        for timeAfterEat in range(6001):
            dp[i][timeAfterEat] = max(dp[i][timeAfterEat], dp[i-1][timeAfterEat])
            
            time = AB[i-1][0]
            value = AB[i-1][1]
            
            if 0 <= timeAfterEat - time and timeAfterEat - time < T:
                dp[i][timeAfterEat] = max(dp[i][timeAfterEat], dp[i-1][timeAfterEat - time] + value)
    
    print(max(dp[N]))

if __name__ == "__main__":
    main()