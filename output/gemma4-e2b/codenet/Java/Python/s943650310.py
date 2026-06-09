import sys

def solve():
    # Read X
    try:
        X = int(sys.stdin.readline())
    except:
        return

    # Read t
    try:
        t = int(sys.stdin.readline())
    except:
        return

    if X - t >= 0:
        print(X - t)
    else:
        print(0)

solve()