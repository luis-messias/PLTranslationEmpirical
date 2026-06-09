import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first token is N
        N = int(data[0])
        # The remaining tokens are the array elements
        A = [int(x) for x in data[1:]]
    except ValueError:
        # Handle case where input might be malformed
        return

    if len(A) != N:
        # Input mismatch, though typically not expected in CP environments
        return

    # Sort the array
    A.sort()

    # Find the minimum element
    min_val = A[0]

    # Check divisibility: if any element is not divisible by min_val, print -1 and stop.
    for value in A:
        if value % min_val != 0:
            print(-1)
            return

    # If all elements are divisible, print the minimum
    print(min_val)

solve()
