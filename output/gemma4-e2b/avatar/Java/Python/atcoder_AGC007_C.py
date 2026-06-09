import sys
from decimal import Decimal, getcontext

# Set precision high enough for intermediate calculations, matching the intent of BigDecimal
getcontext().prec = 50

# Read input from stdin
try:
    # Read N, d, x from standard input, assuming they are provided space-separated
    data = sys.stdin.read().split()
    if len(data) < 3:
        # Handle case where input is insufficient
        exit()
        
    N = float(data[0])
    d = float(data[1])
    x = float(data[2])
except Exception:
    # Exit if input reading fails
    exit()

# Initialize ans using Decimal
ans = Decimal("0.0")

# Perform the iterative calculation
while N > 0.5:
    # Calculate adnum = d + x * (N - 0.5)
    # Use Decimal for high precision arithmetic
    adnum = Decimal(d) + Decimal(