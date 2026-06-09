import sys

try:
    # Read X
    X = int(sys.stdin.readline())
    # Read t
    t = int(sys.stdin.readline())

    if X >= t:
        print(X - t)
    elif X < t:
        print(0)
except:
    # Handle potential empty input or conversion errors if necessary, 
    # though for competitive programming style input, this is often omitted.
    pass