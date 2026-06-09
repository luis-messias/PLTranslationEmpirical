import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if len(data) < 3:
        return

    # W, H, N are the first three values
    w = int(data[0])
    h = int(data[1])
    n = int(data[2])

    # Initialize bounds based on the initial rectangle [0, w] x [0, h]
    xmin = 0
    xmax = w
    ymin = 0
    ymax = h

    data_ptr = 3
    for _ in range(n):
        if data_ptr + 2 >= len(data):
            break
            
        x_i = int(data[data_ptr])
        y_i = int(data[data_ptr + 1])
        a_i = int(data[data_ptr + 2])
        data_ptr += 3

        if a_i == 1:
            # x >= x_i => update xmin
            xmin = max(xmin, x_i)
        elif a_i == 2:
