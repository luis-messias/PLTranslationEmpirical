import sys
import math

def solve():
    # Read the four integers from standard input
    try:
        data = sys.stdin.read().split()
        if len(data) < 4:
            return
        x1 = int(data[0])
        y1 = int(data[1])
        x2 = int(data[2])
        y2 = int(data[3])
    except:
        # Handle potential reading errors if input format is unexpected
        return

    if x1 == x2:
        # Case 1: x1 == x2
        dif = abs(y1 - y2)
        # Output: (x1 + dif) y1 (x1 + dif) y2
        print(f"{x1 + dif} {y1} {x1 + dif} {y2}")
    elif y1 == y2:
        # Case 2: y1 == y2
        dif = abs(x1 - x2)
        # Output: x1 (y1 + dif) x2 (y2 + dif)
        print(f"{x1} {y1 + dif} {x2} {y2 + dif}")
    elif abs(x1 - x2) == abs(y1 - y2):
        # Case 3: |x1 - x2| == |y1 - y2|
        # Output: x1 y2 x2 y1
        print(f"{x1} {y2} {x2} {y1}")
    else:
        # Case 4: Otherwise
        print("-1")

solve()