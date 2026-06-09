import sys

def solve():
    # Read all inputs from stdin and convert to integers
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])
        d = int(data[3])
    except Exception:
        # Handle potential EOF or incorrect input format gracefully if necessary
        return

    if c > b:
        print(0)
    elif a > d:
        print(0)
    elif a < c:
        print(min(b, d) - c)
    else:
        # The 'else' block covers: c <= b AND a <= d AND a >= c
        l = [a, b, c, d]
        l.sort()
        # l[2] is the third smallest, l[1] is the second smallest
        print(l[2] - l[1])

if __name__ == "__main__":
    solve()