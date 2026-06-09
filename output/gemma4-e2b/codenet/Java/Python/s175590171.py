import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        n = int(data[0])
    except ValueError:
        # Handle case where input might be malformed or empty
        return

    if n == 0:
        print(1) # If N=0, the result is likely 1 based on the final print(count+1) structure, though input constraints usually prevent N=0.
        return

    # The rest of the elements are the array A
    if len(data) < n + 1:
        # Not enough elements provided
        return
        
    a = [int(x) for x in data[1:n+1]]
    
    # 1. Sort the array
    a.sort()
    
    # 2. Initialize variables
    sum_val = 0
    count = 0
    
    # 3. Iterate and apply the logic
    # The loop runs for i from 0 to n-2
    for i in range(n - 1):
        sum_val += a[i]
        
        # Check the condition: a[i+1] <= 2