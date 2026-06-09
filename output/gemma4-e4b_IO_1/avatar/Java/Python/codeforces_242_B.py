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
        print(-1)
        return

    A = []
    B = []
    
    # Read N pairs of (A[i], B[i])
    # Data indices start from 1
    for i in range(n):
        data_index_a = 1 + 2 * i
        data_index_b = 2 + 2 * i
        
        if data_index_b >= len(data):
            break
            
        try:
            a_val = int(data[data_index_a])
            b_val = int(data[data_index_b])
            A.append(a_val)
            B.append(b_val)
        except ValueError:
            # Handle non-integer input if necessary, though usually guaranteed in CP
            break

    # Java INF = 10^9 + 5
    INF = 10**9 + 5 
    
    if not A:
        print(-1)
        return

    # Calculate min(A) and max(B
