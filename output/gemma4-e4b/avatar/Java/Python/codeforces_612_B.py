import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # The next N elements are the values A_i
    A = [int(x) for x in data[1:N+1]]
    
    # dp array initialization. Size 200001 is used in Java.
    # We initialize it to a size large enough to hold indices up to N (or 200000).
    MAX_SIZE = 200001
    dp = [0] * MAX_SIZE
    
    # Populate dp: A[j] is the value, j is the position (0-indexed)
    for j in range(N):
        value = A[j]
        # dp[value] = j
        if value < MAX_SIZE:
            dp[value] = j
            
    # Calculate the answer
    ans = 0
    # Loop from i = 2 up to N (inclusive)
    for i in range(2, N + 1):
        # ans += Math.abs(dp[i] - dp[i - 1])
        ans += abs(dp[i] - dp[i - 1])
        
    print(ans)

solve()