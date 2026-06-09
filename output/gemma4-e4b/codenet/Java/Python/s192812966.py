import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # w, h, n are the first three elements
    w = int(data[0])
    h = int(data[1])
    n = int(data[2])

    # Initialize bounds
    xmin = 0
    xmax = w
    ymin = 0
    ymax = h

    # Process the remaining 3*n elements
    data_index = 3
    for _ in range(n):
        # Read x, y, a for the current constraint
        x = int(data[data_index])
        y = int(data[data_index + 1])
        a = int(data[data_index + 2])
        data_index += 3

        # Update bounds based on type 'a'
        if a == 1:
            # xmin = max(xmin, x)
            xmin = max(xmin, x)
        elif a == 2:
            # xmax = min(xmax, x)
            xmax = min(xmax, x)
        elif a == 3:
            # ymin = max(ymin, y)
            ymin = max(ymin, y)
        elif a == 4:
            # ymax = min(ymax, y)
            ymax = min(ymax, y)

    # Calculate final dimensions
    w_new = max(xmax - xmin, 0)
    h_new = max(ymax - ymin, 0)

    print(w_new * h_new)

solve()