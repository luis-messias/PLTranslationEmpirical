import sys

def solve():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()
    if not data:
        return

    data_ptr = 0
    
    while data_ptr < len(data):
        try:
            # Read N (size of the array A)
            n = int(data[data_ptr])
            data_ptr += 1
            
            # Check if we have enough data for array A
            if data_ptr + n > len(data):
                break

            # Read array A
            A = [int(data[data_ptr + i]) for i in range(n)]
            data_ptr += n
            
            # B acts as a visited tracker (0 = unvisited, 1 = visited)
            B = [0] * n
            
            s = -1
            tem = 1  # 1 for forward pass, 0 for backward pass
            q = 0    # Count of elements selected
            
            # Main simulation loop
            while q < n:
                s += 1
                
                if tem == 1:
                    # Forward pass (i = 0 to n-1)
                    for i in range(n):
                        if A[i] <= q and B[i] == 0:
                            B[i] = 1
                            q += 1
                            if q == n:
