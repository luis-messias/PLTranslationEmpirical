import sys

def solve():
    # Read all tokens from standard input
    input_data = sys.stdin.read().split()
    
    if not input_data:
        print(0)
        return

    try:
        # The first token is N
        n = int(input_data[0])
    except ValueError:
        # Handle case where N is not an integer
        print(0)
        return

    # The next N tokens are the array elements
    if len(input_data) < n + 1:
        # Not enough elements provided
        print(0)
        return
        
    array = input_data[1:n+1]
    
    # Sort the array (as done in