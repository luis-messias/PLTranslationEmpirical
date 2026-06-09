import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    try:
        N = int(input_data[0])
        K = int(input_data[1])
        S = input_data[2]
    except IndexError:
        # Handle case where input might be incomplete
        return

    first_time = True
    step = 1
    s_current = S

    while K > 0:
        # 1. Calculate T (S reversed)
        T = S[::-1]
        
        # 2. Calculate revU (S + T, then reversed)
        # In Python, (S + T)[::-1]
        rev_u = (S + T)[::-1]
        
        s_dash = S
        
        # 3. Inner loop to find the lexicographically smallest substring
        # The loop runs from N down to 0, stepping by 'step'
        
        # Note: The Java loop condition i >= 0 and i -= step means i goes down to 0 or below.
        # Since we are taking substrings of length N, the starting index i must satisfy i + N <= len(rev_u).
        # len(rev_u) = 2 * N. So i <= N.
        # The Java loop runs for i = N, N