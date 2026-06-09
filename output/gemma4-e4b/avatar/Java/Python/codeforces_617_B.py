import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        n = int(data[0])
    except IndexError:
        # Handle case where input might only contain N but no values
        return

    # The remaining elements are the N values
    if len(data) < n + 1:
        # Not enough values provided
        return

    input_values = [int(x) for x in data[1:n+1]]

    arr = []
    # Collect indices where the value is 1
    for i in range(n):
        if input_values[i] == 1:
            arr.append(i)

    if not arr:
        print(0)
    else:
        result = 1
        # Calculate the product of differences between consecutive indices
        for i in range(1, len(arr)):
            diff = arr[i] - arr[i - 1]
            result *= diff
        print(result)

solve()