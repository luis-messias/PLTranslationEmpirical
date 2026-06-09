from decimal import Decimal, ROUND_DOWN
import sys

# Read input from stdin. We read two tokens sequentially.
try:
    sa = sys.stdin.readline().strip()
    sb = sys.stdin.readline().strip()
except:
    # Handle case where input might be empty or reading fails
    sys.exit()

if sa and sb:
    A = Decimal(sa)
    B = Decimal(sb)
    
    # Calculate A * B and round down (equivalent to BigDecimal.setScale(0, BigDecimal.ROUND_DOWN))
    result = (A * B).to_integral_value(rounding=ROUND_DOWN)
    
    print(result)