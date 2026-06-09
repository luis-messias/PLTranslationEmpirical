import sys

try:
    # Read input N
    n = int(sys.stdin.read().strip())
except ValueError:
    # Handle case where input is not a valid integer
    sys.exit()

# Print n followed by a space
print(n, end=" ")

m = n
# Iterate i from n-1 down to 1
for i in range(n - 1, 0, -1):
    if m % i == 0:
        # Print i followed by a space
        print(i, end=" ")
        m = i
