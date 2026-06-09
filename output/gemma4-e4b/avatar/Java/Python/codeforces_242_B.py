import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    try:
        n = int(data[0])
    except IndexError:
        # Handle case where input might be empty
        print(-1)
        return

    A = []
    B = []
    
    # Read N pairs of (A[i], B[i])
    # Data indices start from 1
    for i in range(n):
        try:
            a_val = int(data[1 + 2 * i])
            b_val = int(data[2 + 2 * i])
            A.append(a_val)
            B.append(b_val)
        except IndexError:
            # Should not happen if input matches N, but good practice
            break

    # Java INF = 10^9 + 5
    INF = 10**9 + 5 
    
    left = INF
    right = 0
    
    # First loop: Calculate min(A) and max(B)
    for i in range(n):
        a_i = A[i]
        b_i = B