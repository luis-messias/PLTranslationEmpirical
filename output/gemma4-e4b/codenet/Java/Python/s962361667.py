import sys

def solve():
    # Read all input tokens from standard input
    input_data = sys.stdin.read().split()

    if not input_data:
        return

    # w and n are the first two tokens
    try:
        w = int(input_data[0])
        n = int(input_data[1])
    except IndexError:
        return

    # Operation strings start from index 2
    op_strings = input_data[2:]

    # Initialization: values[i] = i + 1
    values = list(range(1, w + 1))

    # Swapping operations
    for i in range(n):
        if i >= len(op_strings):
            break
            
        str_op = op_strings[i]
        
        # Parse "a,b"
        try:
            a_str, b_str = str_op.split(',')
            a = int(a_str)
            b = int(b_str)
        except ValueError:
            continue

        # Convert 1-based indices to 0-based indices
        a_idx = a - 1
        b_idx = b - 1
        
        # Swap values
        values[a_idx], values[b_idx] = values[b_idx], values[a_idx]

    # Output results
    for val in values:
        print(val)

solve()