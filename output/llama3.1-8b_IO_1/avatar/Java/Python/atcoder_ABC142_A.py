from decimal import Decimal, ROUND_HALF_UP
import sys

def main():
    try:
        input_val = float(sys.stdin.readline())
        count_odd = int(input_val / 2) + (input_val % 2)
        result = (Decimal(count_odd) / Decimal(input_val)).quantize(Decimal('0.0000000001'), rounding=ROUND_HALF_UP)
        print(result)
    except (ValueError, Exception) as e:
        print(e)

if __name__ == "__main__":
    main()
