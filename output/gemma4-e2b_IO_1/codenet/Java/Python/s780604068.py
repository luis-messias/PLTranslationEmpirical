import sys

def solve():
    # Read all input data and split into strings
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first element is N
        N = int(data[0])
    except ValueError:
        return

    # Check if we have enough elements (N + 2N = 3N total elements expected if N is read first)
    # Wait, the Java code reads N, then 2N elements. Total elements read should be 1 + 2N.
    if len(data) < 1 + 2 * N:
        return
        
    # The map elements are the remaining 2*N numbers
    map_elements = [int(x) for x in data[1:1 + 2 * N]]
    
    if len(map_elements) != 2 * N:
        return

    map_list = map_elements
    
    # Sort the array
    map_list.sort()
    
    max_val = 0
    # Iterate over the sorted array taking pairs (i, i+1)
    for i in range(0, 2 * N, 2):
        # Calculate the minimum of the pair and add it to the total
        max_val += min(map_list[i], map_list[i + 1])
        
    print(max_val)

solve()
