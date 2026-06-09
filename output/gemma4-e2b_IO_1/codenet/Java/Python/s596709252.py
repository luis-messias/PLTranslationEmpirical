import sys

# Read the input line and split it into integers
try:
    data = sys.stdin.read().split()
    if len(data) >= 3:
        # The input order is x, y, z based on the Java reading order (nextInt() reads sequentially)
        x = int(data[0])
        y = int(data[1])
        z = int(data[2])
        
        # Print z x y
        print(z, x, y)
except:
    # Handle case where input might be empty or malformed
    pass
