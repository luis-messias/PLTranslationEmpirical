import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # n and m are the first two elements
    n = int(data[0])
    m = int(data[1])
    
    if n == 0 or m == 0:
        return

    # Initialize A and b based on the input structure
    A = []
    b = []
    
    data_ptr = 2
    
    # Read matrix A (n * m elements)
    for i in range(n):
        row = []
        for j in range(m):
            if data_ptr < len(data):
                row.append(int(data[data_ptr]))
                data_ptr += 1
            else:
                # Should not happen with valid input structure
                return
        A.append(row)

    # Read vector b (m elements)
    for j in range(m):
        if data_ptr < len(data):
            b.append(int(data[data_ptr]))
            data_ptr += 1
        else:
            return

    # Perform the calculation: calculate dot product of each row of A with b
    for i in range(n):
        c = 0
        for j in range(m):
            c += A[i][j] * b[j]
        print(c)

solve()