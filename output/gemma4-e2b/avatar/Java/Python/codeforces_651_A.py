import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if len(data) < 2:
        return

    try:
        a = int(data[0])
        b = int(data[1])
    except ValueError:
        return

    if a == 1 and b == 1:
        print(0)
        return

    c = 0
    
    # The loop continues as long as a >= 1 or b >= 1
    while a >= 1 or b >= 1:
        if a >= b:
            b += 1
            a -= 2
        else:
            a += 1
            b -= 2
        
        # Check termination condition
        if a <= 0 or b <= 0:
            c += 1
            break
        
        # If loop continues, increment c
        c += 1
        
    print(c)

solve()