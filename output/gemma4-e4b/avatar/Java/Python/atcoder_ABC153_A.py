import sys

def solve():
    # Read input from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        h = int(data[0])
        a = int(data[1])
    except Exception:
        # Handle cases where input might be malformed or empty
        return

    num = 0
    
    # The loop continues as long as h > 0, mimicking the Java for loop condition check
    while h > 0:
        h -= a
        num += 1
        
    print(num)

solve()