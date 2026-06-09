import sys

def solve():
    # Read all input numbers from stdin
    try:
        # Read all tokens and convert them to integers (longs in Java context)
        data = sys.stdin.read().split()
        if len(data) < 4:
            return
        
        a = [int(x) for x in data[:4]]
        
        if len(a) < 4:
            return

        a0, a1, a2, a3 = a[0], a[1], a[2], a[3]
        
        # Calculate the four products:
        # a[0] * a[2]
        # a[1] * a[3]
        # a[0] * a[3]
        # a[1] * a[2]
        
        p1 = a0 * a2
        p2 = a1 * a3
        p3 = a0 * a3
        p4 = a1 * a2
        
        # Find the maximum of these four products
        result = max(p1, p2, p3, p4)
        
        print(result)

    except Exception:
        # Handle potential errors during input/parsing
        pass

solve()