import sys

try:
    # Read the long integer n from standard input
    n = int(sys.stdin.read().strip())
except:
    # Handle case where input might be missing
    sys.exit()

# Calculate the expression: n * (n + 1) / 2 - n
# Since n*(n+1) is always even, integer division (//) is appropriate.
result = (n * (n + 1) // 2) - n

print(result)