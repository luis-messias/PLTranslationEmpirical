from decimal import Decimal, ROUND_DOWN
import sys

def main():
    # Read all tokens from standard input
    input_data = sys.stdin.read().split()
    
    if len(input_data) < 2:
        return

    sa = input_data[0]
    sb = input_data[1]

    # Convert strings to Decimal objects
    A = Decimal(sa)
    B = Decimal(sb)

    # Multiply
    result = A * B

    # Truncate to integer (scale 0, ROUND_DOWN)
    # Quantizing to Decimal('1') with ROUND_DOWN achieves truncation.
    result_truncated = result.quantize(Decimal('1'), rounding=ROUND_DOWN)

    print(str(result_truncated))

if __name__ == "__main__":
    main()