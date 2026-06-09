import math
import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Use an iterator for reading input values
    data_iter = iter(data)
    
    try:
        N = int(next(data_iter))
    except StopIteration:
        return

    x = []
    y = []
    
    # Read coordinates
    for _ in range(N):
        try:
            x.append(int(next(data_iter)))
            y.append(int(next(data_iter)))
        except StopIteration:
            # Handle case where input might be incomplete
            break

    if len(x) != N:
        # Handle case where input reading failed partially
        return

    max_ans = 0.0

    for i in range(N):
        thetas = []
        for j in range(N):
            if i == j:
                continue
            
            # Calculate angle using atan2(dy, dx)
            dy = y[j] - y[i]
            dx = x[j] - x[i]
            thetas.append(math.atan2(dy, dx))
        
        # Sort the angles
        thetas.sort()
        
        # Add the wrap-around angle (the first angle + 2*PI)
        # This is equivalent to calculating the gap between the largest angle and the smallest angle
        if thetas:
            thetas.append(thetas[0] + 2 * math.pi)
        
        # Find the maximum difference between consecutive angles, adjusted by -PI
        current_max_gap = 0.0
        for k in range(len(thetas) - 1):
            # The Java code calculates the difference and subtracts PI
            diff =