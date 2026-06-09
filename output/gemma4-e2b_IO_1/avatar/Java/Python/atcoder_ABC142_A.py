import sys
from decimal import Decimal, ROUND_HALF_UP

try:
    # Read input from stdin
    line = sys.stdin.readline().strip()
    if not line:
        sys.exit(0)
        
    input_val = float(line)
    
    # Replicating Java's Math.round(x) behavior for positive numbers (round half up)
    # Java's Math.round(2.5) is 3. We use int(x + 0.5) for this behavior.
    count_odd = int(input_val / 2 + 0.5)
    
    # Calculate the ratio using Decimal for precision
    # result = countOdd / input
    result_decimal = Decimal(count_odd) / Decimal(input_val)
    
    # Set scale to 10 with RoundingMode.HALF_UP
    # Quantize to 10 decimal places
