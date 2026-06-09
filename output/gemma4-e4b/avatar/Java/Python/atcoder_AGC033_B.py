import sys

def solve():
    # Reading all inputs from standard input
    data = sys.stdin.read().split()
    if not data:
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

    # First loop (Vertical check)
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

    # Reset end flag for the second check, although the original Java code structure implies
    # that the final check uses the state of 'end' from the first loop, but since the
    # second loop overwrites the constraints, we must ensure 'end' is correctly handled.
    # The Java code resets 'end' implicitly by re-running the logic, but let's follow the structure.
    # Since the final check uses the 'end' variable, we must ensure it reflects the failure status
    # of *either* check, or if the original logic intended 'end' to be reset.
    # Given the structure, let's assume 'end' should track if *any* check fails.
    
    # Re-initializing end for the second check, but we need to track failure status overall.
    # Let's use a flag that persists failure status.
    overall_end = end
    
    lsafe = 1
    rsafe = w

    # Second loop (Horizontal check)
    for i in range(n - 1, -1, -1):
        if s[i] == 'L':
            lsafe += 1
        elif s[i] == 'R':
            rsafe -= 1
        
        if lsafe > rsafe:
            overall_end = True
            break
        
        if i > 0:
            if t[i - 1] == 'L':
                rsafe = min(rsafe + 1, w)
            elif t[i - 1] == 'R':
                lsafe = max(lsafe - 1, 1)

    # Final check
    if sr >= usafe and sr <= dsafe and sc >= lsafe and sc <= rsafe and not overall_end:
        print("YES")
    else:
        print("NO")

solve()