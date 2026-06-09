import math
from decimal import Decimal, ROUND_HALF_UP

def main():
    try:
        input_val = float(input())
        count_odd = math.floor(input_val / 2)
        result = (Decimal(count_odd) / Decimal(input_val)).quantize(Decimal('0.0000000000'), rounding=ROUND_HALF_UP)
        print(result)
    except (ValueError, Exception) as e:
        print(e)

if __name__ == "__main__":
    main()