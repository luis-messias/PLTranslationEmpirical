import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # Parse input: n, d, and the list of numbers
    n = int(data[0])
    d = int(data[1])
    nums = [int(x) for x in data[2:]]

    result = 0
    
    # Iterate from i=1 to n-1
    for i in range(1, n):
        # Calculate a = nums[i - 1] - nums[i]
        a = nums[i - 1] - nums[i]
        
        if a >= 0:
            # Calculate the term based on integer division (a // d)
            term = a // d + 1
            
            # Update result
            result += term
            
            # Update nums[i]
            nums[i] += term * d

    print(result)

solve()
