import sys

try:
    # Read all input and split it into integers
    data = sys.stdin.read().split()
    if len(data) >= 3:
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])

        # Check the condition
        if a + b >= c:
            print("Yes")
        else:
            print("No")
except Exception:
    # Handle potential errors during reading or conversion if input format is unexpected
    pass
