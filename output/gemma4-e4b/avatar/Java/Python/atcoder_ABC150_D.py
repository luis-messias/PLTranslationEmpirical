import sys
import math

def get_gcd(a, b):
    """Calculates the Greatest Common Divisor of a and b."""
    return math.gcd(a, b)

def solve():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()
    if not data:
        return

    # N and M are the first two elements
    N = int(data[0])
    M = int(data[1])
    
    # The remaining N elements are the inputs for A
    inputs_a = [int(x) for x in data[2:2+N]]
    
    # Calculate A: a[i] = input_i / 2 (integer division)
    A = [x // 2 for x in inputs_a]

    # Calculate LCM (lcd)
    lcd = 1
    
    for a_i in A:
        # Calculate GCD(lcd, a_i)
        gcd_val = get_gcd(lcd, a_i)
        
        # Calculate new LCM: lcd * a_i / gcd_val
        # Use integer division //
        lcd = (lcd * a_i) // gcd_val
        
        if lcd > M:
            print(0)
            return

    # Second Check
    for a_i in A:
        # Check if (lcd / a_i) % 2 == 0
        # Since lcd is the LCM, it must be divisible by a_i.
        if (lcd // a_i) % 2 == 0:
            print(0)
            return

    # Final Output: (m / lcd + 1) / 2
    # Use integer division //
    result = (M // lcd + 1) // 2
    print(result)

if __name__ == "__main__":
    solve()