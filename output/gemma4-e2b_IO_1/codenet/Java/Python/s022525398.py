import sys

# Read the entire line of input
line = sys.stdin.readline().strip()

# Split the line into tokens (a and b)
parts = line.split()

if len(parts) >= 2:
    a = parts[0]
    b = parts[1]
    # The Java code calculates b + a
    print(b + a)
