import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        print(0)
        return

    try:
        N = int(data[0])
        if N == 0:
            print(0)
            return
        
        # Read the array elements
        a = [int(x) for x in data[1:N+1]]
    except IndexError:
        # Handle case where input might be incomplete
        print(0)
        return
    except ValueError:
        # Handle non-integer input
        print(0)
        return

    # Sort the array
    a.sort()
    
    ans = 0
    
    if N == 1 and a[0] > 1:
        ans = 1
    else:
        j = 0
        while j < N:
            current_val = a[j]
            
            # Count occurrences of current_val starting from
