import sys

try:
    # Read the integer count from standard input
    count = int(sys.stdin.read().strip())
except:
    # Handle case where input might be missing or invalid
    exit()

total = 0
# Calculate the sum of integers from 1 to count
for ix in range(1, count + 1):
    total += ix

print(total)