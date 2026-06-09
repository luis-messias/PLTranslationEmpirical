import sys

try:
    # Read a and b from standard input
    data = sys.stdin.read().split()
    if len(data) < 2:
        # Handle case where input is insufficient
        sys.exit()
    a = int(data[0])
    b = int(data[1])
except:
    # Handle potential reading errors
    sys.exit()

found = False
# Iterate i from 1 to 100000
for i in range(1, 100001):
    # Check if floor(i * 0.08) == a AND floor(i * 0.1) == b
    
    # Math.floor(1.* i *.08) == a  => int(i * 0.08) == a
    cond1 = int(i *