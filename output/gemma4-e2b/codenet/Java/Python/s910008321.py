import sys

def solve():
    # Read h and a from standard input
    try:
        # Read the first integer (h)
        h = int(sys.stdin.readline())
        # Read the second integer (a)
        a = int(sys.stdin.readline())
    except:
        # Handle potential EOF or invalid input if necessary, though usually not required
        return

    if h % a == 0:
        print(h // a)
    else:
        # In Java, h / a performs integer division, so h / a + 1 calculates the ceiling.
        # In Python, h // a is floor division.
        print(h // a + 1)

solve()