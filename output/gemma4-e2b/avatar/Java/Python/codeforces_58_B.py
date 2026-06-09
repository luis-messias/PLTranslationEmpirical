import sys

try:
    # Read input from stdin
    n = int(sys.stdin.read().strip())
except:
    # Handle case where input might be missing or invalid
    sys.exit()

# Print n followed by a space
print(n, end=" ")

m = n
# Iterate i from n-1 down to 1
for i in range(n - 1,