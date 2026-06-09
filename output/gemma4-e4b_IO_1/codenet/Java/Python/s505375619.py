import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N is the first element
    n = int(input_data[0])
    
    if n == 0:
        print(0)
        return

    # V elements are the next N tokens
    v = [int(x) for x in input_data[1:n+1]]
    
    # C elements are the following N tokens
    c = [int(x) for x in input_data[n+1:2*n+1]]

    # Initialize DP array
    dp = [0] * n

    # dp[0] is explicitly set to 0 (already done by initialization)

    # Loop for i = 1 to n-1
    for i in range(1, n):
        # Calculate potential new value: dp[i-1
