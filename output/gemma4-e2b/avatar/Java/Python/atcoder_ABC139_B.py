import sys

def solve():
    # Read A and B from standard input
    try:
        A = int(sys.stdin.readline())
        B = int(sys.stdin.readline())
    except:
        # Handle case where input might be missing or invalid, though typically not needed in competitive programming context
        return

    # The logic from the Java code
    # result = (B - 1) / (A - 1) (integer division)
    if A == 1:
        # Handle division by zero if A-1 is 0 (A=1)
        # If A=1, A-1=0. The problem context usually implies A >= 2 for this formula.
        # Assuming standard constraints where A > 1 based on the formula structure.
        # If A=1, the behavior is undefined by the formula, but let's proceed assuming A > 1 based on the structure.
        # If A=1, the Java code would throw ArithmeticException if A-1=0, but since it's integer division, it would crash.
        # In competitive programming, constraints usually ensure A > 1 if this formula is used.
        pass
    else:
        result = (B - 1) // (A - 1)
        amari = (B - 1) % (A - 1)
        
        if amari != 0:
            result += 1
            
        print(result)

solve()