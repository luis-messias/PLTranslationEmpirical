import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # N is the first element
        n = int(data[0])
        # K is the second element
        k = int(data[1])
        
        # The remaining elements are the array elements
        if len(data) < n + 2:
            # Not enough elements provided
            return
            
        arr = [int(x) for x in data[2:2+n]]
        
    except IndexError:
        # Handle case where input is incomplete
        return
    except ValueError:
        # Handle case where input tokens are not integers
        return

    # Sort the array
    arr.sort()
    
    count = 0
    seen = set()
    
    for x in arr:
        if x % k != 0:
            # Case 1: Not divisible by k
            count += 1
            seen.add(x)
        else:
            # Case 2: Divisible by k
            quotient = x // k
            if quotient not in seen:
                count += 1
                seen.add(x)
                
    print(count)

solve()