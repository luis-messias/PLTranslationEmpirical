from decimal import Decimal, ROUND_DOWN
import sys

try:
    # Read all input and split it by whitespace
    data = sys.stdin.read().split()
    
    if len(data) >= 2:
        sa = data[0]
        sb = data[1]
        
        A = Decimal(sa)
        B = Decimal(sb)
        
        # Calculate A * B and round down (equivalent to BigDecimal.setScale(0, BigDecimal.ROUND_DOWN))
        result = (A * B).to_integral_value(rounding=ROUND_DOWN)
        
        print(result)
except Exception:
    # Handle potential errors if input format is unexpected
    pass
