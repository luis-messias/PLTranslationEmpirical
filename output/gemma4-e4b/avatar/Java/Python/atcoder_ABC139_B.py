import sys

def solve():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        A = int(data[0])
        B = int(data[1])
    except IndexError:
        # Handle case where not enough input is provided
        return

    # The calculation logic from the Java code
    # Note: This assumes A > 1 to avoid ZeroDivisionError
    
    if A == 1:
        # If A=1, the original Java code would throw ArithmeticException (division by zero).
        # Depending on problem constraints, this case might need specific handling.
        # Assuming A > 1 based on typical usage of this formula.
        return

    # Calculate (B - 1) / (A - 1) using integer division
    result = (B - 1) // (A - 1)
    
    # Calculate the remainder
    amari = (B - 1) % (A - 1)
    
    # If the remainder is non-zero, increment the result (equivalent to ceiling division)
    if amari != 0:
        result += 1
    
    print(result)

solve()