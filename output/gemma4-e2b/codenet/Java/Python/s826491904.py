import sys

def solve():
    # Read all integers from standard input
    try:
        data = list(map(int, sys.stdin.read().split()))
    except:
        # Handle case where input might be empty or malformed
        return

    if len(data) < 2:
        return

    # N is the first element
    N = data[0]
    
    # The second element is used to initialize max and min
    if len(data) < 2:
        return
        
    max_val = data[1]
    min_val = data[1]
    
    # Iterate over the remaining N-1 elements (starting from index 2)
    # The loop runs for the remaining elements provided in the input stream
    for i in range(2, len(data)):
        in_val = data[i]
        max_val = max(max_val, in_val)
        min_val = min(min_val, in_val)
        
    print(max_val - min_val)

solve()