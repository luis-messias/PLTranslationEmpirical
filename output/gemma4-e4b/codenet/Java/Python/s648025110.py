import sys

def solve():
    # Read all input data and split it into tokens
    data = sys.stdin.read().split()
    
    if not data:
        print(0)
        return

    # The first element is N
    try:
        n = int(data[0])
    except ValueError:
        print(0)
        return

    # The remaining elements are the array H
    if n > 0:
        h = []
        try:
            h = [int(x) for x in data[1:n+1]]
        except ValueError:
            # Handle case where remaining data might not be integers
            h = []
    else:
        h = []

    ans = 0
    out = 0

    for height in h:
        if out < height:
            ans += height - out
            out = height
        else:
            out = height

    print(ans)

solve()