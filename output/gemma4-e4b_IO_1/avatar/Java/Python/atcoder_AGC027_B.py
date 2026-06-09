import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element, X is the second. Use int() as Python handles large integers.
    N = int(data[0])
    X = int(data[1])
    
    # x elements start from index 2
    # We use map(int, ...) for efficiency and clarity
    x = [int(d) for d in data[2:2+N]]
    
    # xsum[i] stores the sum of x[0] through x[i-1]
    xsum = [0] * (N + 1)
    for i in range(N):
        xsum[i+1] = xsum[i] + x[i]

    # Initialization: ans = X * N + 5 * xsum[N]
    ans = X * N + 5 * xsum[N]

    # Outer loop: i from 1 to N-1
    for i in range(1, N):
        # cost initialization: X * i + 5 * ( xsum[ N ] - xsum[ N - i ] )
        cost = X * i + 5 * (xsum[N] - xsum[N - i])
        
        # Inner loop: j starts at 5, k starts at N - i
        j = 5
        k = N - i
        
        while k >= 0:
            if cost > ans:
                break
            
            # cost += j * ( xsum[ k ] - xsum[ max( k - i , 0 ) ] )
            term = j * (xsum[k] - xsum[max(k - i, 0)])
            cost += term
            
            # Update j and k
            j += 2
            k -= i
        
        # ans = min(ans, cost)
        ans =
