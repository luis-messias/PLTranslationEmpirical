from decimal import Decimal, getcontext
import sys

def solve():
    # Set high precision for Decimal calculations
    getcontext().prec = 50

    # Read all inputs from stdin (assuming N, d, x are provided sequentially)
    try:
        input_data = sys.stdin.read().split()
        if len(input_data) < 3:
            return
        
        # Convert inputs to Decimal objects
        N = Decimal(input_data[0])
        d = Decimal(input_data[1])
        x = Decimal(input_data[2])
    except Exception:
        return

    ans = Decimal("0.0")
    
    # The loop runs while N > 0.5 and N is decremented by 1.0 each iteration.
    while N > Decimal("0.5"):
        # adnum = d + x * (N - 0.5)
        adnum = d + x * (N - Decimal("0.5"))
        
        # ans = ans + adnum
        ans = ans + adnum
        
        # d = (N + 1.0) * d / N + (5.0 * x) / (2.0 * N)
        term1 = (N + Decimal("1.0")) * d / N
        term2 = (Decimal("5.0") * x) / (Decimal("2.0") * N)
        d = term1 + term2
        
        # x = (1.0 + (2.0 / N)) * x
        x = (Decimal("1.0") + (Decimal("2.0") / N)) * x
        
        # N = N - 1.0
        N = N - Decimal("1