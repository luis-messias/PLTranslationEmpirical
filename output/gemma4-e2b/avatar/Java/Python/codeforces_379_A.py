import sys

def solve():
    # Read a and b from standard input
    try:
        # Read the line and split it into two integers
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        a = int(data[0])
        b = int(data[1])
    except:
        # Handle potential reading errors if input format is unexpected
        return

    res = a
    
    # The loop condition and operations mirror the Java logic
    while a >= b:
        # res += (a / b)  (Integer division in Python is //)
        res += a // b
        
        # a = (a / b) + (a % b)
        a = (a // b) + (a % b)
        
    print(res)

solve()