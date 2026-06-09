import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The input reading logic in the Java code is sequential reading of integers.
    # We assume the input stream provides N, W, followed by N pairs of (v_i, w_i).
    
    try:
        # N and W are the first two integers
        N = int(data[0])
        W = int(data[1])
        
        if N == 0:
            print(0)
            return

        # Initialize arrays for values (v) and weights (w). 
        # We use 1-based indexing, so size N+1.
        v = [0] * (N + 1)
        w = [0] * (N + 1)
        
        data_idx = 2
        
        # Read N pairs of (v_i, w_i)
        for i in range(1, N + 1):
            if data_idx + 1 >= len(data):
                # Handle case where input might be incomplete
                break
            
            v[i] = int(data[data_idx])
            w[i] = int(data[data_idx + 1])
            data_idx += 2

    except IndexError:
        # Handle insufficient input if parsing fails
        return
    except ValueError:
        # Handle case where input tokens are not integers
        return

    # Dynamic Programming for 0/1 Knapsack
    # sumV[i][j] stores the maximum value using the first i items with capacity j.
    sumV = [[0] * (W + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        # w[i] is the weight of the current item i
        current_weight = w[i]
        # v[i] is the value of the current item i
        current_value = v[i]
        
        for j in range(W + 1):
            # Case 1: Item i is not included
            sumV[i][j] = sumV[i-1][j]
            
            # Case 2: Item i is included, if capacity allows
            if j >= current_weight:
                # Compare not including vs including
                sumV[i][j] = max(sumV[i][j], sumV[i-1][j - current_weight] + current_value)

    # The result is the maximum value achievable with N items and capacity W
    print(sumV[N][W])

solve()