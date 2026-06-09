import sys

def solve():
    # Read all input data from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N, M, X are the first three elements
    N = int(data[0])
    M = int(data[1])
    X = int(data[2])
    
    # Read the matrix A (N rows, M+1 columns)
    A = []
    data_index = 3
    
    for i in range(N):
        row = []
        for j in range(M + 1):
            row.append(int(data[data_index]))
            data_index += 1
        A.append(row)

    min_val = float('inf')
    
    # Iterate through all 2^N subsets (i is the bitmask)
    num_subsets = 1 << N
    
    for i in range(num_subsets):
        # Initialize sum array for the current subset
        res = [0] * (M + 1)
        
        # Calculate sums based on the selected rows
        for j in range(N):
            # Check if the j-th bit is set in i (i.e., row j is selected)
            if (i >> j) & 1:
                # Add row A[j] to the running sum res
                for k in range(M + 1):
                    res[k] += A[j][k]
        
        # Check validity: res[j] >= X for j = 1 to M
        is_valid = True
        for j in range(1, M + 1):
            if res[j] < X:
                is_valid = False
                break
        
        # Update minimum if valid
        if is_valid:
            # res[0] is the value we minimize
            min_val = min(min_val, res[0])

    # Output result
    if min