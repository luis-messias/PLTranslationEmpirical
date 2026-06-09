import sys

def solve():
    # Read all input lines and convert to integers
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        a = int(data[0])
        b = int(data[1])
    except Exception:
        # Handle case where input might be missing or malformed
        return

    res = a
    while a >= b:
        # Integer division in Python is //
        res += a // b
        
        # Update a: (a // b) + (a % b)
        a = (a // b) + (a % b)
    
    print(res)

solve()