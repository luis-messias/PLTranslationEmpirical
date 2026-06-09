import sys

def solve():
    # Read all input data from stdin and split it into tokens
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        A = int(data[0])
        B = int(data[1])
        n = int(data[2])
    except Exception:
        # Handle case where input might be missing or malformed
        return

    # Case 1: A = 0
    if A == 0:
        if B == 0:
            print(1)
        else:
            print("No solution")
        return

    # Case 2: Divisibility check
    if B % A != 0:
        print("No solution")
        return

    # Calculate B' = B / A
    B_prime = B // A

    # Check sign and parity
    neg = B_prime < 0
    
    if neg and n % 2 == 0:
        print("No solution")
        return

    # Use the absolute value of B' for the search loop
    B_abs = abs(B_prime)

    # Search loop: x^n == B_abs
    # Iterate x from 0 up to B_abs (inclusive)
    for x in range(B_abs + 1):
        # Calculate x^n
        try:
            power_val = x ** n
        except OverflowError:
            # If the power calculation overflows standard integer limits, skip
            continue

        if power_val == B_abs:
            # Solution found
            if neg:
                print(-x)
            else:
                print(x)
            return

    # No solution found
    print("No solution")

if __name__ == "__main__":
    solve()