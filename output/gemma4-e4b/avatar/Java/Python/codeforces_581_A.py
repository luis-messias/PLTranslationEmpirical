import sys

def solve():
    # Read all input tokens and convert to integers
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        a = int(data[0])
        b = int(data[1])
    except Exception:
        # Handle case where input might be missing or malformed
        return

    count = 0
    
    # Simulate the loop logic
    while a > 0 and b > 0:
        count += 1
        a -= 1
        b -= 1
    
    # Calculate ans using integer division (// in Python)
    ans = a // 2 + b // 2
    
    print(f"{count} {ans}")

solve()