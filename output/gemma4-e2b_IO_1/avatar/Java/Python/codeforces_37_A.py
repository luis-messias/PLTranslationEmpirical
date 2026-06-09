import sys

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except ValueError:
        return

    if len(input_data) < n + 1:
        return

    # The subsequent elements are the values to count
    elements = [int(x) for x in input_data[1:]]
    
    # Calculate frequencies
    counts = {}
    for val in elements:
        counts[val] = counts.get(val, 0) + 1
        
    if not counts:
        return

    # Find the maximum frequency
    max_freq = 0
    for freq in counts.values():
        if freq > max_freq:
            max_freq = freq
            
    # Calculate the number of distinct elements (map size)
    map_size = len(counts)
    
    # Output the result: max_freq and map_size
    print(f"{max_freq} {map_size}")

solve()
