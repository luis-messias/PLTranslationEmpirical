import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    if not data:
        return

    N = int(data[0])
    T = int(data[1])
    
    # Read AB array (N pairs of [time, value])
    AB = []
    data_index = 2
    for _ in range(N):
        time = int(data[data_index])
        value = int(data[data_index + 1])
        AB.append([time, value])
        data_index += 2

    # Sort AB based on time (AB[i][0])
    AB.sort(key=lambda x: x[0])

    # dp[i][t]: max value considering first i items, ending at time t
    # Size: (N+1) x 6001
    MAX_TIME = 6001
    dp = [[0] * MAX_TIME for _ in range(N + 1)]

    for i in range(1, N + 1):
        # Current item is AB[i-1]
        time = AB[i - 1][0]
        value = AB[i - 1][1]
        
        for time_after_eat in range(MAX_TIME):
            # 1. Option: Skip item i-1
            dp[i][time_after_eat] = dp[i - 1][time_after_eat]
            
            # 2. Option: Include item i-1
            # Calculate the time before eating this item: prev_time = time_after_eat - time
            prev_time = time_after_eat - time
            
            # Check constraints:
            # a) Must have enough time (prev_time >= 0)
            # b) The time elapsed (time_after_eat - time) must be less than T
            if 0 <= prev_time and prev_time < T:
                # Maximize: current value vs (previous max value + current value)
                dp[i][time_after_eat] = max(
                    dp[i][time_after_eat], 
                    dp[i - 1][prev_time] + value
                )

    # The result is the maximum value in the last row (dp[N])
    print(max(dp[N]))

solve()