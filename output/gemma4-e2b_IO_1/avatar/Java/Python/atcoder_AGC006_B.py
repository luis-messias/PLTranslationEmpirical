import sys

def solve():
    # Read input from stdin
    try:
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        n = int(data[0])
        x = int(data[1])
    except:
        return

    max_val = n * 2 - 1

    if x == 1 or x == max_val:
        print("No")
    else:
        print("Yes")

solve()
