import sys

def solve(n):
    # Equivalent to (n / 3) * 2 + (n % 3 == 0 ? 0 : 1)
    # Using integer division (//) and conditional expression
    result = (n // 3) * 2 + (0 if n % 3 == 0 else 1)
    print(result)

# Read input N from standard input
try:
    # Read all input and strip whitespace, then convert to integer
    n = int(sys.stdin.read().strip())
    solve(n)
except:
    # Handle case where input might be empty
    pass