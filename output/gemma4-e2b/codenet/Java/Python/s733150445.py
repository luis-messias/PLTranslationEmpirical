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

        # Parse them as Decimal objects (equivalent to BigDecimal)
        a = Decimal(parts[0])
        b = Decimal(parts[1])
        
        # Calculate the product
        mul = a * b
        
        # Mimic the Java logic: get the string representation and split by '.'
        mul_str = str(mul)
        
        if '.' in mul_str:
            # Split the string by the decimal point and take the second part
            fractional_part = mul_str.split('.', 1)[1]
            print(fractional_part)
        else:
            # Handle cases where the result is an integer (e.g., 5.0 -> "5.0" -> "0")
            # If the result is an integer (e.g., 5), the fractional part is effectively empty or 0.
            # Since the Java code relies on splitting, if no '.' exists, we assume the fractional part is empty or handle it based on the split result.
            # If mul = 5, str(mul) = "5". No split occurs. We print nothing or handle based on context.
            # Based on the Java logic, if no '.' exists, nextElement() would fail or return an empty string if we strictly follow the split logic.
            # For safety, if no decimal is present, we print nothing, or perhaps the whole string if we interpret the intent loosely.
            # Sticking to the explicit split logic: if no '.', we don't print anything derived from the split.
            pass

    except Exception:
        # Handle potential errors during input or conversion
        pass

if __name__ == "__main__":
    main()