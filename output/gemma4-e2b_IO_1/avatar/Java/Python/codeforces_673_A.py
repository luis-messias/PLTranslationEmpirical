import sys

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    try:
        # The first element is N
        n = int(input_data[0])
    except ValueError:
        return

    if n == 0:
        return

    # The remaining elements are the array a
    if len(input_data) < n + 1:
        # Not enough elements provided
        return
        
    a = [int(x) for x in input_data[1:n+1]]

    if not a:
        return

    result = 0
    
    # Case 1: Check the first element
    if a[0] > 15:
        result = 15
    else:
        # Case 2: Check for large gaps
        pos = 0
        flag = 0
        
        for i in range(1, n):
            if a[i] - a[i - 1] > 15:
                # Found a gap. pos should be the index before the gap (i-1)
                pos = i - 1
                flag = 1
                break
        
        if flag == 1:
            # If a gap was found, use the element before the gap
            result = a[pos] + 15
        else:
            # If no gap was found, use the last element
            result = a[n - 1] + 15

    # Final constraint
    if result > 90:
        result = 90
        
    print(result)

solve()
