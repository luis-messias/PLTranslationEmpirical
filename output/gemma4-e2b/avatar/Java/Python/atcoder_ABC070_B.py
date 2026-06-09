import sys

def solve():
    # Read all four integers from standard input
    try:
        data = sys.stdin.read().split()
        if len(data) < 4:
            return
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])
        d = int(data[3])
    except Exception:
        # Handle potential errors during input reading if necessary
        return

    if c > b:
        print(0)
    elif a > d:
        print(0)
    elif a < c:
        print(min(b, d) - c)
    else:
        # This corresponds to the final 'else' block in the Java code
        l = [a, b, c, d]
        l.sort()
        # l.get(2) is the 3rd element, l.get(1) is the 2nd element (0-indexed)
        print(l[2] - l[1])

solve()