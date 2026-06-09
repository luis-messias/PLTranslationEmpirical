import math
import sys

def dist(x1, y1, x2, y2):
    return math.sqrt((x1 - x2)**2 + (y1 - y2)**2)

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first integer
    N = int(data[0])
    
    # The remaining data are the coordinates (x_i, y_i)
    points = []
    data_index = 1
    for _ in range(N):
        if data_index + 1 < len(data):
            x = int(data[data_index])
            y = int(data[data_index + 1])
            points.append((x, y))
            data_index += 2
        else:
            # Handle case where input might be incomplete, though unlikely in competitive programming context
            break

    total_sum = 0.0
    
    # Calculate the sum of distances for all ordered pairs (i, j) where i != j
    for i in range(N):
        for j in range(N):
            if i != j:
                x1, y1 = points[i]
                x2, y2 = points[j]
                total_sum += dist(x1, y1, x2, y2)
                
    # Output sum / N
    if N > 0:
        print(total_sum / N)

solve()