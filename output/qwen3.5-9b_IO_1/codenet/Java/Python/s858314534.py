import sys

# Read all input
input_data = sys.stdin.read().split()
A = int(input_data[0])
B = int(input_data[1])
T = int(input_data[2])

# Calculate and print result
print((T // A) * B)
