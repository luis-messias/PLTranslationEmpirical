import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if len(data) < 7:
        return

    # Parse inputs
    h = int(data[0])
    w = int(data[1])
    n = int(data[2])
    sr = int(data[3])
    sc = int(data[4])
    s = data[5]
    t = data[6]

    # --- Vertical constraints check ---
    end = False
    usafe = 1
    dsafe = h

    # Iterate backwards over s (s represents the path)
    for i in range(n - 1, -1, -1):
        if s[i] == 'U':
            usafe += 1
        elif s[i] == 'D':
            dsafe -= 1
        
        if usafe > dsafe:
            end = True
            break
        
        # Adjust bounds based on t (t represents the turns)
        if i > 0:
            # t[i-1] corresponds to the turn that happened just before index i in s
            if t[i - 1] == 'U':
                dsafe = min(dsafe + 1, h)
            elif t[i - 1] == 'D':
                usafe = max(usafe - 1, 1)

    # --- Horizontal constraints check ---
    lsafe = 1
    rsafe = w

    # Iterate backwards over s
    for i in range(n - 1, -1, -1):
        if s[i] == 'L':
            lsafe += 1
        elif s[i] == 'R':
            rsafe -= 1
        
        if lsafe > rsafe:
            end = True
            break
        
        # Adjust bounds based on t
        if i > 0:
            if t[i - 1] == 'L':
                rsafe = min(rsafe + 1, w)
            elif t[i - 1] == 'R':
                lsafe = max(lsafe - 1, 1)
