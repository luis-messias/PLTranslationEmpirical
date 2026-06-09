import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if len(data) < 7:
        return

    h = int(data[0])
    w = int(data[1])
    n = int(data[2])
    sr = int(data[3])
    sc = int(data[4])
    s = data[5]
    t = data[6]

    end = False
    usafe = 1
    dsafe = h

    # First loop: Vertical constraints (U/D)
    for i in range(n - 1, -1, -1):
        if s[i] == 'U':
            usafe += 1
        elif s[i] == 'D':
            dsafe -= 1
        
        if usafe > dsafe:
            end = True
            break
        
        if i > 0:
            if t[i - 1] == 'U':
                dsafe = min(dsafe + 1, h)
            elif t[i - 1] == 'D':
                usafe = max(usafe - 1, 1)

    lsafe = 1
    rsafe = w

    # Second loop: Horizontal constraints (L/R)
    for i in range(n - 1, -1, -1):