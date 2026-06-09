import sys

def solve():
    # Read all input from stdin and split it
    try:
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        X = int(data[0])
        t = int(data[1])
    except:
        # Handle case where input reading fails
        return

    if X - t >= 0:
        print(X - t)
    else:
        print(0)

solve()
