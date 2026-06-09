import sys

def checKNo(brr):
    val = 0
    for x in brr:
        if x == 1:
            val += 1
    return val

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    try:
        n = int(input_data[0])
        if n == 0:
            return
        
        arr = [int(x) for x in input_data[1:n+1]]
    except IndexError:
        # Handle case where input might be incomplete
        return
    except ValueError:
        # Handle case where input elements are not integers
        return

    if n == 1:
        if arr[0] == 1:
            print(0)
        else:
            print(1)
    else:
        max_count = -1 # Initialize to a value lower than any possible count (which is >= 0)
        
        # Iterate over all subarrays arr[i..j]
        for i in range(n):
            for j in range(i, n):
                # Create a copy of arr (brr)
                brr = list(arr)
                
                # Flip elements in the range [i, j]
                for k in range(i, j + 1):
                    # Flip: 0 -> 1, 1 -> 0
                    if brr[k] == 0:
                        brr[k] = 1
                    else:
                        brr[k] = 0
                
                # Calculate count
                count = checKNo(brr)
                
                # Update max
                if count > max_count:
                    max_count = count