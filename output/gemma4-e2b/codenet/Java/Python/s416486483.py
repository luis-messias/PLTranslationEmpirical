import sys

def split(n: int, k: int) -> int:
    """Calculates the sum of digits of n when represented in base k."""
    sum_val = 0
    while n > 0:
        sum_val += n % k
        n //= k
    return sum_val

def solve(n: int, s: int) -> int:
    k = 2
    # First loop: Check small k
    while k * k <= n or k < 100:
        if split(n, k) == s:
            return k
        k += 1

    # Second loop: Complex search
    while k <= n:
        a = n // k
        b = n % k
        
        # Check if (a + b - s) is divisible by a
        if (a + b - s) % a == 0:
            dk = (a + b - s) // a
            
            # Check constraints
            if dk >= 0 and b - dk * a >= 0:
                return k + dk
        
        # Update k for the next iteration
        k = n // a + 1

    # Final check
    if n == s:
        return n + 1
        
    return -1

def main():
    # Read input from stdin
    try:
        # Read nl and sl from a single line, assuming they are space-separated
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        nl = int(data[0])
        sl = int(data[1])
        
        result = solve(nl, sl)
        print(result)
        
    except Exception as e:
        # Handle potential errors during input/conversion
        pass

if __name__ == "__main__":
    main()