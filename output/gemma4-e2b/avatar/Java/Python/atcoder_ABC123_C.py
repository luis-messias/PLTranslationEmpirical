import sys
import math

def solve():
    # Read all input tokens from stdin
    try:
        data = sys.stdin.read().split()
    except:
        return

    if not data:
        return

    # N is the first number
    N = int(data[0])

    # The next 5 numbers are the ones used to find the minimum
    if len(data) < 6:
        # Not enough input provided
        return

    A = [int(x) for x in data[1:6]]

    # Find the minimum of the 5 numbers
    min_val = min(A)

    # Calculate the result: ceil(N / min) + 4
    # Note: Python's division operator (/) results in a float, and math.ceil works on floats.
    result = math.ceil(N / min_val) + 4

    # Print the result
    print(int(result))

solve()