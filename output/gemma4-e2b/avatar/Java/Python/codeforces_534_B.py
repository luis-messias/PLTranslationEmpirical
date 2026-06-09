import sys

def solve():
    # Read input from stdin
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        v1 = int(data[0])
        v2 = int(data[1])
        t = int(data[2])
        d = int(data[3])
    except Exception:
        # Handle case where input might be missing or malformed if running interactively
        return

    N_MAX = 1150
    
    # dp[i][j]
    # We need t-1 rows, indexed 0 to t-2
    # Columns 0 to 1149 (size 1150)
    
    # Initialize DP table with a very small number (negative infinity)
    # Using a large negative number instead of actual float infinity for integer DP
    NEG_INF = -10**18 
    
    # dp table size: (t-1) rows, 1150 columns
    dp = [[NEG_INF] * N_MAX for _ in range(t - 1)]

    # Base case: dp[0][v1] = v1
    if v1 < N_MAX:
        dp[0][v1] = v1

    # DP transition
    # i iterates from 1 to t-2 (inclusive)
    for i in range(1, t - 1):
        # j iterates over columns
        for j in range(N_MAX):
            
            # Transition 1: dp[i][j] = max(dp[i][j], dp[i-1][j+x] + j) for 0 <= x <= d
            for x in range(d + 1):
                if j + x < N_MAX:
                    # dp[i-1][j+x] must be reachable (not NEG_INF)
                    if dp[i - 1][j + x] != NEG_INF:
                        dp[i][j] = max(dp[i][j], dp[i - 1][j + x] + j)

            # Transition 2: dp[i][j] = max(dp[i][j], dp[i-1][j-x] + j) for 0 <= x <= d
            for x in range(d + 1):
                if j - x >= 0:
                    # dp[i-1][j-x] must be reachable
                    if dp[i - 1][j - x] != NEG_INF:
                        dp[i][j] = max(dp[i][j], dp[i - 1][j - x] + j)


    # Final result calculation
    ans = -10**18
    
    # Check results from the last relevant row, which is t-2
    if t > 1:
        i =