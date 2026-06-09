import math
import sys

def dist(x1, y1, x2, y2):
    return math.sqrt((x1 - x2)**2 + (y1 - y2)**2)

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # Read coordinates
    pos = []
    data_index = 1
    for _ in range(N):
        x = int(data[data_index])
        y = int(data[data_index + 1])
        pos.append((x, y))
        data_index += 2

    total_sum = 0.0
    
    # Calculate the sum of distances
    for i in range(N):
        x1, y1 = pos[i]
        for j in range(N):
            if i == j:
                continue
            x2, y2 = pos[j]
            total_sum += dist(x1, y1, x2, y2)

    # Output the result
    print(total_sum / N)

if __name__ == "__main__":
    solve()