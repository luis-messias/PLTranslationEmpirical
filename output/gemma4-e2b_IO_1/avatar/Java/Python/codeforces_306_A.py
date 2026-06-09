import sys

def solve():
    # Read input from stdin
    try:
        # Read n and m from the input line
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        n = int(data[0])
        m = int(data[1])
    except Exception:
        # Handle case where input might be missing or invalid, though for competitive programming context, we assume valid input structure.
        return

    # Initialize the array a of size m
    a = [0] * m

    if n % m == 0:
        # Case 1: n is divisible by m
        result = n // m
        for i in range(m):
            a[i] = result
    else:
        # Case 2: n is not divisible by m
        sub = n // m
        for i in range(m):
            a[i] = sub
        
        test = n - (sub * m)
        count = 0
        
        # Increment the first 'test' elements by 1, wrapping around
        for i in range(test):
            a[count] += 1
            count = (count + 1) % m

    # Output the elements separated by spaces
    print(*(a))
