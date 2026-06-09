import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # N is the first element
        N = int(data[0])
        
        # A are the next N elements
        A = [int(x) for x in data[1:N+1]]
    except (ValueError, IndexError):
        # Handle malformed input if necessary, though usually guaranteed by problem constraints
        return

    # Sort the array
    A.sort()

    # The minimum element is A[0]
    min_val = A[0]

    # Check if every element is divisible by min_val
    for value in A:
        if value % min_val != 0:
            print(-1)
            return

    # If all elements are divisible, print the minimum
    print(min_val)

if __name__ == "__main__":
    solve()