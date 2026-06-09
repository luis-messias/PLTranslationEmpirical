import sys

def solve():
    # Read all input data from stdin and split it into tokens
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    try:
        # The first element is N
        N = int(input_data[0])
    except ValueError:
        return

    # Extract the N elements that follow N
    if len(input_data) < N + 1:
        return

    A = [int(x) for x in input_data[1:N+1]]

    min_abs = float('inf')
    count = 0
    sum_abs = 0
    
    for val in A:
        if val < 0:
            count += 1
        
        abs_val = abs(val)
        
        if abs_val < min_abs:
            min_abs = abs_val
        
        sum_abs += abs_val

    if count % 2 == 0:
        print(sum_abs)
    else: