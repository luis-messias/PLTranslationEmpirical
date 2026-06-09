import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element, X is the second
    N = int(data[0])
    X = int(data[1])
    
    # x elements start from index 2
    x = [int(d) for d in data[2:2+N]]
    
    # xsum[i] stores the sum of x[0] through x[i-1]
    xsum = [0] * (N + 1)
    for i in range(N):
        xsum[i+1] = xsum[i] + x[i]

    # Initialization: ans = X * N + 5 * xsum[N]
    ans = X * N + 5 * xsum[N]

    # Outer loop: i from 1 to N-1
    for i in range(1, N):
        # cost initialization
        cost = X * i + 5 * (xsum[N] - xsum[N -