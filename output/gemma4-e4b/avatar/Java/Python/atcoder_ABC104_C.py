import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # Pointer for reading input tokens
    idx = 0

    # Read D
    D = int(input_data[idx])
    idx += 1

    # Read G (Target score)
    G = int(input_data[idx])
    idx += 1

    # Read p and c arrays
    p = [0] * D
    c = [0] * D
    for i in range(D):
        p[i] = int(input_data[idx])
        idx += 1
        c[i] = int(input_data[idx])
        idx += 1

    INF = 100000
    min_solve = INF

    # Iterate through all 2^D subsets
    for bit in range(1 << D):
        score = 0
        solve_num = 0

        # 1. Calculate initial score and solve_num for the selected subset
        for i in range(D):
            if (bit & (1 << i)):
                # Score contribution: 100 * (i + 1) * p[i] + c[i]
                score += 100 * (i + 1) * p[i] + c[i]
                solve_num += p[i]

        # 2. Greedy Extension (if score < G)
        if score < G:
            # We need to iterate backwards and potentially break out of multiple loops
            
            # Flag to track if the target G was reached during extension
            target_reached = False
            
            for i in range(D - 1, -1, -1):
                # If option i was NOT selected in the initial subset
                if not (bit & (1 << i)):
                    
                    # We can add up to p[i] - 1 units
                    units_to_add = p[i] - 1
                    
                    for _ in range(units_to_add):
                        if target_reached:
                            break
                        
                        # Score increases by 100 * (i + 1)
                        score += 100 * (i + 1)
                        solve_num += 1
                        
                        if score >= G:
                            target_reached = True
                            break
                
                if target_reached:
                    break

        # 3. Update Minimum
        if score >= G