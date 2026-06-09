import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first token is n
        n = int(data[0])
        
        # The remaining tokens are the counts
        if len(data) < n + 1:
            # Not enough counts provided
            return
            
        counts = [int(x) for x in data[1:n+1]]
    except ValueError:
        # Handle case where input might not be integers
        return

    # Initialize cnt array of size 21 to zeros
    cnt = [0] * 21

    # Process the counts
    for i in range(n):
        # The Java code uses scan.nextInt() sequentially.
        # The i-th count read corresponds to counts[i]
        # Index calculation: counts[i] + 10
        index = counts[i] + 10
        
        # Ensure index is within bounds [0, 20] before incrementing
        if 0 <= index <= 20:
            cnt[index] += 1

    # Calculate result
    res = 0
    
    # Calculate sum of products: cnt[i
