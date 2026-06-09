import sys

try:
    # Read all input and split into tokens
    data = sys.stdin.read().split()
    if len(data) >= 3:
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])

        count = 0
        # Iterate from a to b (inclusive)
        for i in range(a, b + 1):
            if c % i == 0:
                count += 1

        print(count)
except:
    # Handle potential errors during reading or conversion
    pass
