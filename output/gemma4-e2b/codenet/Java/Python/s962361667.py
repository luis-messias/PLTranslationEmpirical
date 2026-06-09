import sys

def solve():
    # Read w and n from standard input
    try:
        # Read w
        w_line = sys.stdin.readline()
        if not w_line:
            return
        w = int(w_line.strip())
        
        # Read n
        n_line = sys.stdin.readline()
        if not n_line:
            return
        n = int(n_line.strip())
    except EOFError:
        return
    except ValueError:
        # Handle case where w or n are not integers
        return

    # Initialize values: values[i] = i + 1
    values = [0] * w
    for i in range(w):
        values[i] = i + 1

    # Perform n swaps
    for _ in range(n):
        line = sys.stdin.readline().strip()
        if not line:
            continue
        
        try:
            # Split the line by comma
            parts = line.split(',')
            if len(parts) < 2:
                continue
            
            # Parse indices, subtracting 1 as done in Java
            a = int(parts[0]) - 1
            b = int(parts[1]) - 1
            
            # Ensure indices are within bounds (though problem constraints usually guarantee this)
            if 0 <= a < w and 0 <= b < w:
                # Swap values
                x = values[a]
                values[a] = values[b]
                values[b] = x
        except ValueError:
            # Skip line if parsing fails
            continue

    # Output the results
    for val in values:
        print(val)

solve()