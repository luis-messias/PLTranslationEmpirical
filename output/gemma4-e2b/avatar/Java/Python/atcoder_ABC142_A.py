import sys
from decimal import Decimal, ROUND_HALF_UP

try:
    # Read input from stdin
    line = sys.stdin.readline().strip()
    if not line:
        sys.exit(0)
        
    input_val = float(line)
    
    # Calculate countOdd: Math.round(input / 2)
    count_odd = round(input_val / 2)
    
    # Calculate the ratio using Decimal for precision, mimicking BigDecimal behavior
    # result = countOdd / input
    result_decimal = Decimal(count_odd) / Decimal(input_val)
    
    # Set scale to 10 with RoundingMode.HALF_UP
    # Quantize to 10 decimal places
    result_scaled = result_decimal.quantize(Decimal('1e-10'), rounding=ROUND_HALF_UP)
    
    # Print the result
    print(result_scaled)

except Exception:
    # In a strict translation, we might handle specific exceptions, 
    # but for general execution, we let standard error handling occur if input fails.
    pass