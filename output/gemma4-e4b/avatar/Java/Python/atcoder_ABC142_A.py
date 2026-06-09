import sys
from decimal import Decimal, ROUND_HALF_UP

def main():
    # Read the single line input from standard input
    try:
        input_line = sys.stdin.read().strip()
        if not input_line:
            return
        
        # Use Decimal for precise handling of floating-point numbers
        input_val = Decimal(input_line)
    except Exception:
        # Handle cases where input reading or parsing fails
        return

    # 1. Calculate countOdd = Math.round(input / 2)
    # Calculate input / 2
    half_input = input_val / Decimal(2)
    
    # Round to the nearest integer (simulating Math.round)
    # Quantize to '1' (integer place) using ROUND_HALF_UP
    count_odd = half_input.quantize(Decimal('1'), rounding=ROUND_HALF_UP)
    
    # 2. Calculate result = countOdd / input
    result = count_odd / input_val

    # 3. Format the output to 10 decimal places (BigDecimal behavior)
    # Create the template for 10 decimal places: '0.0000000000'
    ten_places = Decimal('0.' + '0' * 10)
    
    # Quantize the result to 10 decimal places using HALF_UP rounding
    final_result = result.quantize(ten_places, rounding=ROUND_HALF_UP)

    print(str(final_result))

if __name__ == "__main__":
    main()