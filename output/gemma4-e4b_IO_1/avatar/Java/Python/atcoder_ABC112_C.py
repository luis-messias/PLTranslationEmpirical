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
    # The subsequent logic handles this case correctly based on the Java implementation.

    # 2. Verify all points
    for i in range(n):
        # Calculate the required value for h[i] based on the current
