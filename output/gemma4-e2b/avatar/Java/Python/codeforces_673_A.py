import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        n = int(data[0])
    except ValueError:
        # Handle case where the first token is not an integer
        return

    if n == 0:
        # If n is 0, there is nothing to process, result is undefined based on logic, 
        # but we must handle the array access safely.
        # Since the logic relies on a[0], we might just exit or assume constraints prevent n=0.
        return

    # Extract the array elements
    if len(data) < n + 1:
        # Not enough elements provided
        return
        
    a = [int(x) for x in data[1:n+1]]

    result = 0
    
    # Check the first element
    if a[0] > 15:
        result = 15
    else:
        # Check for large gaps
        pos = 0
        flag = 0
        
        for i in range(1, n):
            if a[i] - a[i - 1] > 15:
                pos = i - 1
                flag = 1
                break
        
        if flag == 1:
            result = a[pos] + 15
        else:
            # If no gap found, use the last element
            result = a[n - 1] + 15

    # Final constraint
    if result > 90:
        result = 90
        
    print(result)

solve