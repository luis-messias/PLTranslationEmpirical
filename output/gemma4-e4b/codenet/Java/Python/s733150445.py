import sys
from decimal import Decimal

def solve():
    # Read the entire line from standard input
    try:
        line = sys.stdin.readline().strip()
    except EOFError:
        return

    if not line:
        return

    # Split the line and convert to Decimal
    parts = line.split()
    if len(parts) < 2:
        return

    try:
        a = Decimal(parts[0])
        b = Decimal(parts[1])
    except Exception:
        # Handle cases where conversion fails
        return

    # Multiply the numbers
    mul = a * b

    # Get the string representation of the result
    mul_str = str(mul)

    # Find the integer part (the part before the decimal point)
    if '.' in mul_str:
        integer_part = mul_str.split('.')[0]
    else:
        integer_part = mul_str

    print(integer_part)

if __name__ == "__main__":
    solve()