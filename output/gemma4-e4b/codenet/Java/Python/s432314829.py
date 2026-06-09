import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element, M is the second.
    N = int(data[0])
    M = int(data[1])
    
    # Initialize DP array of size N+2
    dp = [0] * (N + 2)
    
    # Set base cases
    dp[N + 1] = 0
    dp[N] = 1
    
    # Process M blocked indices. They start from data[2].
    for i in range(M):
        blocked_index = int(data[2 + i])
        dp[blocked_index] = -1
        
    MOD = 1000000007
    
    # DP calculation loop: from N-1 down to 0
    for i in range(N - 1, -1, -1):
        if dp[i] == -1:
            dp[i] = 0
        else:
            # dp[i] = (dp[i + 1] + dp[i + 2]) % MOD
            dp[i] = (dp[i + 1] + dp[i + 2]) % MOD
            
    print(dp[0])

solve()