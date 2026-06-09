import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is n
    try:
        n = int(data[0])
    except ValueError:
        # Handle case where the first element is not an integer
        return

    # The remaining elements are the array h
    if len(data) < n + 1:
        # Not enough elements provided
        return
        
    h = [int(x) for x in data[1:n+1]]

    ans = 0
    out = 0

    for val in h:
        if out < val:
            ans += val - out
            out = val
        else:
            out = val

    print(ans)

solve()