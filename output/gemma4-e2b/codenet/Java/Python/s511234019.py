import sys

try:
    # Read the two integers from standard input
    a = int(sys.stdin.readline())
    b = int(sys.stdin.readline())
except:
    # Handle potential empty input or conversion errors if necessary, though usually not needed for direct translation context
    exit()

if a % 2 == 0 or b % 2 == 0:
    print("No")
else:
    print("Yes")