import sys

def solve():
    # Read input from stdin
    try:
        data = sys.stdin.read().split()
    except:
        return

    if not data:
        return

    # D is the first integer
    D = int(data[0])
    # G is the second integer
    G = int(data[1])
    
    # p and c arrays start from index 2
    p = [0] * D
    c = [0] * D
    
    data_idx = 2
    for i in range(D):
        if data_idx + 1 < len(data):
            p[i] = int(data[data_idx])
            c[i] = int(data[data_idx + 1])
            data_idx += 2
        else:
            # Handle case where input might be incomplete, though unlikely in CP context
            return

    INF = 100000
    min_val = INF

    # Iterate through all subsets (bitmasks)
    for bit in range(1 << D):
        score = 0
        solve_num = 0
        
        # Calculate initial score and solve_num based on the current subset 'bit'
        for i in range(D):
            # Check if the i-th element is selected (bit & (1 << i)) != 0
            if (bit & (1 << i)) != 0:
                # Java uses 1-based indexing for score calculation: 100 * (i + 1) * p[i] + c[i]
                score += 100 * (i + 1) * p[i] + c[i]
                solve_num += p[i]
        
        if score < G:
            # Try to increase the score by including unselected elements
            
            # The Java code iterates backwards and tries to add items from unselected indices
            # to reach G.
            
            # Note: The logic here is highly specific to the original problem structure.
            # We must replicate the exact behavior of the nested loops.
            
            # We use a temporary score and solve_num for this branch, starting from the initial state.
            
            current_score = score
            current_solve_num = solve_num
            
            # Iterate backwards over indices i
            for i in range(D - 1, -1, -1):
                # If the i-th element is NOT selected
                if (bit & (1 << i)) == 0:
                    # Try to add items related to p[i]
                    # The loop runs for j from 0 up to p[i] - 2 (since j < p[i] - 1)
                    for j in range(p[i] - 1):
                        # Add 100 * (i + 1) to score
                        current_score += 100 * (i + 1)
                        # Increment solve_num
                        current_solve_num += 1
                        
                        if current_score >= G:
                            break
                    
                    if current_score >= G:
                        break
            
            # Update score and solve_num if the optimization succeeded
            if current_score >= G:
                min_val = min(min_val, current_solve_num)

        # Check if the initial selection already satisfies the condition
        if score >= G:
            min_val = min(min_val, solve_num)

    print(min_val)

solve()