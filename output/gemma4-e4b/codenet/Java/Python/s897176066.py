import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    try:
        # N is the first element
        N = int(input_data[0])
        
        # A are the next N elements
        A = [int(x) for x in input_data[1:N+1]]
    except IndexError:
        # Handle case where input might be incomplete
        return

    # Sort the array
    A.sort()
    
    # Check for duplicates
    for j in range(1, N):
        if A[j] == A[j-1]:
            print("NO")
            sys.exit(0)
            
    # If no duplicates found
    print("YES")

solve()