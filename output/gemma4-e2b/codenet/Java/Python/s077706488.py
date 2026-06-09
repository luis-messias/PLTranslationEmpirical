import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element
    N = int(data[0])
    # X is the second element
    X = int(data[1])
    
    # The remaining elements are the array m
    m = [int(x) for x in data[2:]]
    
    if N == 0:
        return

    # m[0] is the first element read
    m0 = m[0]
    
    # X -= m[0]
    X -= m0
    
    # min initialized to m[0]
    min_val = m0
    
    # Loop through the rest of the elements m[1] to m[N-1]
    for i in range(1, N):
        mi = m[i]
        # X -= m[i]
        X -= mi
        
        # Update minimum
        if mi < min_val:
            min_val = mi
            
    # Output N + X/min (using integer division // as implied by Java integer arithmetic)
    result = N + X // min_val
    print(result)

solve()