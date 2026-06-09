import sys

# Read all input tokens
data = sys.stdin.read().split()

if len(data) > 1:
    # The first element is n, the rest are the array elements
    # We only care about the array elements starting from index 1
    array = [int(x) for x in data[1:]]
    
    if array:
        max_val = max(array)
        min_val = min(array)
        print(max_val - min_val)
