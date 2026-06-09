import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    n = int(data[0])
    
    # The array a contains the next N elements
    a = [int(x) for x in data[1:n+1]]

    # DP array initialization
    # dp will have size n + 1
    dp = [-1] * (n + 1)
    
    # Base case: dp[n-1] = a[n-1] (using 0-based indexing for a)
    if n > 0:
        dp[n - 1] = a[n - 1]

        # DP calculation (backward pass)
        # dp[i] = max(dp[i+1], a[i])
        for i in range(n - 1, -1, -1):
            dp[i] = max(dp[i + 1], a[i])

        # Output calculation
        results = []
        for i in range(n):
            # We compare a[i] with dp[i+1]
            if a[i] > dp[i + 1]:
                results.append("0")
            else:
                # dp[i+1] - a[i] + 1
                results.append(str(dp[i + 1] - a[i] + 1))
        
        print(" ".join(results))

solve()