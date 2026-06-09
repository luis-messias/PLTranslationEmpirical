def maxLeft(n):
    return n - 2 if n > 2 else 0

import sys

def solve():
    # Read all input lines and process them sequentially
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is T
    try:
        t = int(input_data[0])
    except ValueError:
        return

    # Process the next T elements (N values)
    for i in range(t):
        try:
            n = int(input_data[i + 1])
            print(maxLeft(n))
        except IndexError:
            # Should not happen if input matches T
            break

solve()