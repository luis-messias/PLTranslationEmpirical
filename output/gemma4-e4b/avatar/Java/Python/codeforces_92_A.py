import sys

def solve():
    # Read all input from stdin and split into tokens
    data = sys.stdin.read().split()
    if not data:
        return

    # Assuming the first two tokens are n and k
    n = int(data[0])
    k = int(data[1])

    i = 1
    req = 1

    while k - req >= 0:
        # k = k - req
        k = k - req
        
        # i++
        i += 1
        
        # Update req
        if i % n != 0:
            req = i % n
        else:
            req = n

    print(k)

solve()