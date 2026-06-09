import sys

try:
    # Read the input line and split it into X and t
    data = sys.stdin.read().split()
    if len(data) >= 2:
        X = int(data[0])
        t = int(data[1])

        if X >= t:
            print(X - t)
        else:
            print(0)
except:
    # Handle potential errors during reading or conversion
    pass
