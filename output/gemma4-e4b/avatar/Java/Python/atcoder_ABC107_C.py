import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    if not data:
        return

    N = int(data[0])
    K = int(data[1])
    S = [int(x) for x in data[2:2+N]]

    if K == 1:
        ans = float('inf')
        for s_i in S:
            ans = min(abs(s_i), ans)
        print(ans)
    elif N - K != 0:
        ans = 1000000000
        # Loop runs from i=0 up to N-K inclusive
        for i in range(N - K + 1):
            min_val = S[i]
            max_val = S[i + K - 1]
            
            if min_val < 0 and max_val > 0:
                # Math.min(2 * (-min) + max, (-min) + 2 * max)
                temp = min(2 * (-min_val) + max_val,