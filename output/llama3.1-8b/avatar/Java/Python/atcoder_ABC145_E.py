import sys
from typing import List

def main():
    N, T = map(int, input().split())
    AB = [[0, 0] for _ in range(N)]
    for i in range(N):
        AB[i][0], AB[i][1] = map(int, input().split())

    AB.sort(key=lambda x: x[0])

    dp = [[0]*6001 for _ in range(N+1)]

    for i in range(1, N+1):
        for time_after_eat in range(6001):
            dp[i][time_after_eat] = max(dp[i][time_after_eat], dp[i-1][time_after_eat])
            time, value = AB[i-1]
            if 0 <= time_after_eat - time and time_after_eat - time < T:
                dp[i][time_after_eat] = max(dp[i][time_after_eat], dp[i-1][time_after_eat-time] + value)

    print(max(dp[N]))

if __name__ == "__main__":
    main()