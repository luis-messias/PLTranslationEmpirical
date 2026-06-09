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

    # The remaining elements are the 2*N numbers
    if len(data) < N + 1:
        return
        
    map_elements = [int(x) for x in data[1:]]
    
    # Ensure we have exactly 2*N elements, although based on the problem structure, 
    # we assume the input provides exactly N and 2N subsequent numbers.
    if len(map_elements) != 2 * N:
        return

    map_list = map_elements
    
    # Sort the array
    map_list.sort()
    
    max_val = 0
    # Iterate over the sorted array taking pairs (i, i+1)
    for i in range(0, 2 * N, 2):
        # Calculate the minimum of the pair and add it to the total
        max_val