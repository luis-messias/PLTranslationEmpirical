import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # n and k are the first two inputs
    n = int(data[0])
    k = int(data[1])
    
    # The rest of the inputs form array a
    a = [int(x) for x in data[2:]]
    
    M = 200010
    
    # Initialize frequency array x
    x = [0] * M
    
    # Populate x based on array a
    for val in a:
        index = val - 1
        # Ensure index is within bounds [0, M-1]
        if 0 <= index < M:
            x[index] += 1
            
    # Sort x
    x.sort()
    
    # Calculate the sum of the first M - k elements
    # The loop limit in Java was i <= 200010 - k - 1, which means summing M - k elements.
    limit = M - k
    ans = 0
    
    # Sum the first 'limit' elements of the sorted array x
    for i in range(limit):
        ans += x[i]
        
    print(ans)

solve()