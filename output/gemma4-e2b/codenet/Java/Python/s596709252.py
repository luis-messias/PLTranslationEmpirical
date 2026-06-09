import sys

try:
    # Read x
    x = int(sys.stdin.readline())
    # Read y
    y = int(sys.stdin.readline())
    # Read z
    z = int(sys.stdin.readline())
    
    # Print z x y
    print(z, x, y)
except:
    # Handle potential EOF or invalid input if necessary, though usually omitted in simple translations
    pass