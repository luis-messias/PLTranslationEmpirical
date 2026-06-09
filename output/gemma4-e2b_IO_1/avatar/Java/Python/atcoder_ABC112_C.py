import sys
import math

def check(n, x, y, h, cx, cy):
    ch = -1
    # First loop: find the minimum required height based on the current point (cx, cy)
    for i in range(n):
        if h[i] > 0:
            # ch = |x[i] - cx| + |y[i] - cy| + h[i]
            ch = abs(x[i] - cx) + abs(y[i] - cy) + h[i]
            break
    
    if ch == -1:
        # If no point has h[i] > 0, we might need a different base case, but based on Java logic, ch remains -1 if no point satisfies h[i]>0.
        # However, the Java code assumes a point with h[i]>0 exists if the input is valid.
        # If ch remains -1, the subsequent check loop might behave unexpectedly if we rely on ch > 0.
        # Let's
