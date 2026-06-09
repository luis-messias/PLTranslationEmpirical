import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N, L, R, QL, QR are the first 5 elements
    N = int(data[0])
    L = int(data[1])
    R = int(data[2])
    QL = int(data[3])
    QR = int(data[4])

    # W elements start from index 5
    W = [int(x) for x in data[5:5+N]]

    # Calculate prefix sums
    # sum_arr[i] stores the sum of W[0]...W[i-1]
    sum_arr = [0] * (N + 1)
    for i in range(N):
        sum_arr[i+1] = sum_arr[i] + W[i]

    # Initialize min cost (using a large number equivalent to Long.MAX_VALUE)
    min_cost = float('inf')

    # Iterate through all possible split points (firstR = 0 to N)
    for firstR in range(N + 1):
        lCount = firstR
        rCount = N - lCount

        # Calculate the base cost: sum_left * L + sum_right * R
        # sum_arr[lCount] is the sum of the left part
        # sum_arr[N] - sum_arr[lCount] is the sum of the right part
        
        cand = sum_arr[lCount] * L + (sum_arr[N] - sum_arr[lCount]) * R

        # Calculate adjustment costs
        # Math.max(0, ...) translates to max(0, ...)
        llCount = max(0, lCount - rCount - 1)
        rrCount = max(0, rCount - lCount - 1)
        
        cand += llCount * QL
        cand += rrCount * QR
        
        min_cost = min(cand, min_cost)

    print(min_cost)