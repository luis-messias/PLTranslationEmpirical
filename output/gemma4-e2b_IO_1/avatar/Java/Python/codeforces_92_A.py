import sys

def solve():
    # Read all input data
    try:
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        n = int(data[0])
        k = int(data[1])
    except:
        # Handle potential reading errors if input format is unexpected
        return

    i = 1
    req = 1

    # The loop continues as long as k is greater than or equal to the required subtraction amount (req)
    while k >= req:
        # Subtract req from k
        k = k - req
        
        # Increment i
        i += 1
        
        # Update req based on i and n
        if i % n != 0:
            req = i % n
        else:
            req = n

    print(k)

solve()
