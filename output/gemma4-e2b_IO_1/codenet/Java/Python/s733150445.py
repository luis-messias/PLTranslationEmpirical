import sys
from decimal import Decimal

def main():
    # Read the entire line of input
    try:
        line = sys.stdin.readline().strip()
        if not line:
            return
        
        # Split the line into two numbers
        parts = line.split()
        if len(parts) != 2:
            return

        # Parse them as Decimal objects
        a = Decimal(parts[0])
        b = Decimal(parts[1])
        
        # Calculate the product
        mul = a * b
        
        # Based on the expected output (217 for 217.8), we extract the integer part.
        result = int(mul)
        
        print(result)

    except Exception:
        # Handle potential errors during input or conversion
        pass

if __name__ == "__main__":
    main()
