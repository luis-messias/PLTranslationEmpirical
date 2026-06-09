import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        n = int(data[0])
    except ValueError:
        # Handle case where the first token is not an integer
        return

    d = 0
    # Iterate through the next n elements, starting from index 1
    # These elements are the numbers x_i
    for i in range(1, n + 1):
        if i < len(data):
            try:
                x = int(data[i])
                d += x % 2
            except ValueError:
                # Skip if a subsequent token is not an integer
                continue
        else:
            # Ran out of input prematurely
            break

    # The Java code checks if d is even (d % 2 == 0)
    if d % 2 == 0:
        print("YES")
    else:
        print("NO")

solve()