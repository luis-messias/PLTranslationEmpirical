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
        print(0)
        return

    # The next N tokens are the array elements
    if len(input_data) < n + 1:
        # Handle case where input is incomplete
        print(0)
        return
        
    array = input_data[1:n+1]
    
    # Sort the array
    array.sort()
    
    # Count the number of distinct elements
    distinct_count = len(set(array))
    
    print(distinct_count)

if __name__ == "__main__":
    solve()
