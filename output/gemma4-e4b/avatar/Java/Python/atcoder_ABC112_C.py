import sys

def check(n, x, y, h, cx, cy):
    """
    Checks if the center (cx, cy) satisfies the conditions defined by the points (x, y, h).
    Returns the calculated 'ch' value if valid, otherwise returns -1.
    """
    ch = -1
    
    # 1. Find the initial 'ch' based on the first point with h[i] > 0
    for i in range(n):
        if h[i] > 0:
            # ch = |x[i] - cx| + |y[i] - cy| + h[i]
            ch = abs(x[i] - cx) + abs(y[i] - cy) + h[i]
            break
    
    # If no point with h[i] > 0 was found, ch remains -1.
    if ch == -1:
        # If ch is -1, the subsequent check logic might fail or behave unexpectedly.
        # However, based on the Java code structure, if ch is -1, the second loop 
        # will calculate max(-1 - dist, 0), which is 0 if dist >= -1 (always true).
        # If ch is -1, the condition h[i] != max(..., 0) will likely fail unless h[i] is 0.
        # We proceed with the logic as written in Java.
        pass

    # 2. Verify all points
    for i in range(n):
        # Calculate the required value for h[i] based on the current ch
        # Required h[i] = max(ch - (|x[i] - cx| + |y[i] - cy|), 0)
        required_h = max(ch - (abs(x[i] - cx) + abs(y[i] - cy)), 0)
        
        if h[i] != required_h:
            return -1
            
    return ch

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    data_iter = iter(data)
    
    try:
        n = int(next(data_iter))
    except StopIteration:
        return

    x = [int(next(data_iter)) for _ in range(n)]
    y = [int(next(data_iter)) for _ in range(n)]
    h = [int(next(data_iter)) for _ in range(n)]

    MAX = 100

    for i in range(MAX + 1):
        for j in range(MAX + 1):
            ch = check(n, x, y, h, i, j)
            if ch > 0:
                print(f"{i} {j} {ch}")

if __name__ == "__main__":
    solve()