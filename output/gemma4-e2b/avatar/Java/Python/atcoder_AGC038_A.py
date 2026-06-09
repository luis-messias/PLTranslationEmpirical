import sys

def solve():
    # Read H, W, A, B from standard input
    try:
        # Read all inputs, assuming they are provided on separate lines or space-separated
        # Since the Java code uses nextInt() sequentially, we read them one by one.
        input_data = sys.stdin.read().split()
        if len(input_data) < 4:
            return
        
        H = int(input_data[0])
        W = int(input_data[1])
        A = int(input_data[2])
        B = int(input_data[3])
    except Exception:
        # Handle case where input reading fails
        return

    # Check the initial condition
    if W < 2 * A or H < 2 * B:
        print(-1)
        return

    # Generate and print the grid
    for i in range(H):
        row = []
        for j in range(W):
            # Condition for '0': (i < B and j < A) OR (i >= B and j >= A)
            is_zero = (i < B and j < A) or (i >= B and j >= A)
            
            if is_zero:
                row.append('0')
            else:
                row.append('1')
        
        print("".join(row))

solve()