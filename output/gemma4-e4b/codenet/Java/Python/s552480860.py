import sys

def solve():
    # Read all inputs from standard input and map them to integers
    try:
        data = sys.stdin.read().split()
        if len(data) < 5:
            return

        h1 = int(data[0])
        m1 = int(data[1])
        h2 = int(data[2])
        m2 = int(data[3])
        k = int(data[4])

        t1 = h1 * 60 + m1
        t2 = h2 * 60 + m2
        print(t2 - t1 - k)

    except Exception:
        # Handle potential reading errors
        pass

solve()