import sys

try:
    # Read the line and split it into A and B
    line = sys.stdin.read().split()
    if len(line) < 2:
        # Handle case where not enough input is provided
        exit()
    A = int(line[0])
    B = int(line[1])
except:
    # Handle potential errors during conversion
    exit()

if (A % 3 == 0) or (B % 3 == 0) or ((A + B) % 3 == 0):
    print("Possible")
else:
    print("Impossible")
