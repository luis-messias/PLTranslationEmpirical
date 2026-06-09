import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    if not data:
        return

    # n = data[0], k = data[1]
    n = int(data[0])
    k = int(data[1])
    
    # a = data[2] to data[2+n-1]
    a = [int(x) for x in data[2:2+n]]

    MAX_VAL = 200010
    
    # Initialize frequency array x
    x = [0] * MAX_VAL
    
    # Count frequencies
    for val in a:
        # Assuming 1 <= val <= 200010
        x[val - 1] += 1
    
    # Sort the frequency array x (replicates Java's behavior)
    x.sort()
    
    # Calculate the sum of the first (200010 - k) elements
    limit = MAX_VAL - k
    
    # Summing x[0] up to x[limit - 1]
    ans = sum(x[:limit])
    
    print(ans)

solve()