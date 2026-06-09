import sys

def solve():
    # Read all input tokens
    try:
        data = sys.stdin.read().split()
    except:
        return

    if not data:
        return

    # Input reading based on the Java structure
    
    if len(data) < 2:
        return

    try:
        m = int(data[0])
        n = int(data[1])
    except ValueError:
        return

    if m == 0 or n == 0:
        # Handle trivial cases if necessary, though the DP structure handles m+1, n+1
        return

    if len(data) < 2 + m + 2 * n:
        # Not enough data for all inputs
        return

    # manju array (m elements)
    manju = [int(x) for x in data[2:2+m]]
    
    # boxlen and boxcost arrays (n pairs)
    boxlen = [0] * n
    boxcost = [0] * n
    
    data_idx = 2 + m
    for i in range(n):
        if data_idx + 1 >= len(data):
            # Should not happen if input is well-formed
            break
        boxlen[i] = int(data[data_idx])
        boxcost[i] = int(data[data_idx+1])
        data_idx += 2

    # Sort manju (equivalent to Java's sort(manju))
    manju.sort()

    # DP initialization: dp[i][j]
    # Dimensions: (m+1) x (n+1)
    # Initialize with 0s
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    # DP calculation
    # i iterates from m-1 down to 0
    # j iterates from n-1 down to 0
    for i in range(m - 1, -1, -1):
        for j in range(n - 1, -1, -1):
            
            # The Java code uses dp[i][j] initialized to 0 implicitly before the max operations.
            
            # Calculate the potential transition using box j
            
            # len calculation: i + boxlen[j]
            # Java: int len=i+boxlen[j]>=m?m:i+boxlen[j];
            len_candidate = i + boxlen[j]
            len_actual = min(m, len_candidate)
            
            cnt = 0
            if len_actual > i:
                # Calculate cnt: sum of manju[m-1-k] for k from i to len_actual - 1
                # This sums the items that are being covered by the box, relative to the end of the sorted list.
                # The items being summed are manju[m - len_actual] through manju[m - i - 1]
                
                # The Java loop: for(int k=i;k<len;k++) cnt+=manju[m-1-k];
                # If i=0, len=m, k=0..m-1. cnt += manju[m-1], manju[m-2], ..., manju[0]. This is the sum of all items.
                
                # Let's stick to the Java index calculation:
                # k runs from i to len-1. Indices accessed are m-1-k.
                
                # If i=0, j=0, boxlen[0]=5, m=10. len=5. k=0..4. cnt += manju[9], manju[8], ..., manju[5].
                # This sums the last 5 items of manju.
                
                for k in range(i, len_actual):
                    # The index being summed is m - 1 - k, if we consider the indices relative to the end.
                    # Let's re-examine the indices based on the structure:
                    # If len = L, we sum L elements. The indices are m-L, m-L+1, ..., m-1.
                    # The loop
