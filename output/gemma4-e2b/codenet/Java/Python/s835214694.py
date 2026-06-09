import sys

try:
    # Read a
    a = int(sys.stdin.readline())
    # Read b
    b = int(sys.stdin.readline())
    
    if b % a == 0:
        print(a + b)
    else:
        print(b - a)
except:
    # Handle potential errors during input reading
    pass