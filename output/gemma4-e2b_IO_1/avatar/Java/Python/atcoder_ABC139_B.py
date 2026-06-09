import sys

def solve():
    # Read A and B from standard input
    try:
        # Read all tokens from stdin and convert to integers
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        A = int(data[0])
        B = int(data[1])
    except ValueError:
        # Handle case where input is not valid integers
        return

    # The logic from the Java code:
    # result = (B - 1) / (A - 1) (integer division)
    # amari = (B - 1) % (A - 1)
    # if (amari != 0) { result += 1 }

    # Check for division by zero (A - 1 must be non-zero)
    if A > 1:
        # Calculate result using integer division
        result = (B - 1) // (A - 1)
        
        # Calculate remainder
        amari = (B - 1) % (A - 1)
        
        # Adjust result if remainder is non-zero
        if amari != 0:
            result += 1
            
        print(result)

solve()
