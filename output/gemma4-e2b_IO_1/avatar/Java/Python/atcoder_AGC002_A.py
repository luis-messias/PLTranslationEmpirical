import sys

try:
    # Read the input line and split it into a and b
    data = sys.stdin.read().split()
    if len(data) < 2:
        sys.exit()
    a = int(data[0])
    b = int(data[1])
except:
    sys.exit()

if a > 0:
    print("Positive")
elif b >= 0:
    print("Zero")
elif (b - a + 1) % 2 == 0:
    print("Positive")
else:
    print("Negative")
