import math
import sys

def solve():
    # Read the first line (N and D)
    try:
        line = sys.stdin.readline().strip()
        if not line:
            return
        
        parts = line.split()
        N = int(parts[0])
        D = float(parts[1])
    except Exception:
        return

    count = 0
    
    # Process the next N lines
    for _ in range(N):
        line = sys.stdin.readline().strip()
        if not line:
            break
        
        try:
            parts = line.split()
            if len(parts) < 2:
                continue
            
            # x and y are coordinates, read as floats
            x = float(parts[0])
            y = float(parts[1])
        except ValueError:
            continue
        
        # Calculate distance: sqrt(x^2 + y^2)
        distance = math.hypot(x, y)
        
        if distance <= D:
            count += 1
            
    print(count)

solve()
