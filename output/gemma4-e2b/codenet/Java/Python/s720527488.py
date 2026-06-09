import sys
import math

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Input reading based on the Java structure
    
    # m and n are the first two integers
    m = int(data[0])
    n = int(data[1])
    
    # manju array (m elements)
    manju = [int(x) for x in data[2:2+m]]
    
    # boxlen and boxcost arrays (n pairs)
    boxlen = [0] * n
    boxcost = [0] * n
    
    data_idx = 2 + m
    for i in range(n):
        boxlen[i] = int(data[data_idx])
        boxcost[i] = int(data[data_idx+1])
        data_idx += 2

    # Sort manju (equivalent to Java's sort(manju))
    # The Java sort implementation is complex (random swaps + Arrays.sort). 
    # We use Python's built-in sort for simplicity and correctness.
    manju.sort()

    # DP initialization: dp[i][j]
    # Dimensions: (m+1) x (n+1)
    # Initialize with 0s, as the Java code implicitly initializes int arrays to 0.
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    # DP calculation
    # i iterates from m-1 down to 0 (representing the number of items considered)
    # j iterates from n-1 down to 0 (representing the number of boxes considered)
    for i in range(m - 1, -1, -1):
        for j in range(n - 1, -1, -1):
            
            # Base case: dp[i][j] is initialized implicitly or handled by transitions.
            # The Java code initializes dp[i][j] implicitly before the max operations.
            
            # The Java code uses dp[i][j] = Math.max(dp[i][j], ...)
            # Since we are iterating backwards, we need to ensure the base values are handled correctly.
            
            # The Java code initializes dp[i][j] implicitly before the loop starts, 
            # but since it's an array of ints, it starts at 0.
            
            # We need to handle the transition logic carefully.
            
            # The transition logic seems to be:
            # Try to use box j to cover items from i up to i + boxlen[j]
            
            # The Java code uses i and j as indices into the DP table, representing prefixes.
            
            # Let's re-examine the Java loop structure:
            # for(int i=m-1;i>=0;i--){
            #     for(int j=n-1;j>=0;j--){
            #         int len=i+boxlen[j]>=m?m:i+boxlen[j];
            #         int cnt=0;
            #         for(int k=i;k<len;k++) cnt+=manju[m-1-k];
            #         dp[i][j]=Math.max(dp[i][j],dp[len][j+1]+cnt-boxcost[j]);
            #         dp[i][j]=Math.max(dp[i][j],dp[i][j+1]);
            #     }
            # }
            
            # Note: The Java code uses dp[i][j] for the current state, and updates it based on future states (len, j+1 or i, j+1).
            
            # Since we are iterating backwards (i