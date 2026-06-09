import sys

def split(n: int, k: int) -> int:
    """Calculates the sum of digits of n when represented in base k."""
    sum_val = 0
    while n > 0:
        sum_val += n % k
        n //= k
    return sum_val

def solve(n: int, s: int) -> int:
    """Finds the smallest k such that split(n, k) == s, or returns a larger k based on specific logic."""
    
    # First loop: k from 2 up to 99 (or until k*k > n, whichever is later)
    k = 2
    while k * k <= n or k < 100:
        if split(n, k) == s:
            return k
        k += 1

    # Second loop: Handling larger k values
    # Note: k is now 100 (or potentially larger if the loop condition was complex, 
    # but based on the Java structure, k starts where the previous loop left off, 
    # which is 100 if n is large, or 100 if n is small).
    
    # We must ensure k starts at the value it reached after the first loop.
    # Since the Java loop increments k *after* checking the condition, 
    # if the loop terminated because k=100, the next check starts with k=100.
    
    # We use the current value of k (which is 100 if n >= 1)
    while k <= n:
        a = n // k
        b = n % k
        
        # Check if (a + b - s) is divisible by a
        if a == 0:
            # Avoid division by zero if n < k (though k <= n check should prevent this if n >= 0)
            # If a=0, the condition (a + b - s) % a == 0 is problematic.
            # Given the context, if a=0, we likely skip this iteration or handle it based on constraints.
            # Assuming n >= 0 and k >= 2, a=0 only if k > n. Since we check k <= n, a >= 1.
            pass
        elif (a + b - s) % a == 0:
            dk = (a + b - s) // a
            
            if dk >= 0 and b - dk * a >= 0:
                return k + dk
        
        # Update k for the next iteration
        # The Java code uses: k = n / a + 1;
        if a == 0:
            # This case should not happen if k <= n
            break
        k = n // a + 1

    # Final checks
    if n == s:
        return n + 1
    
    return -1

def main():
    # Read input from stdin
    try:
        # Reading two long integers
        input_data = sys.stdin.read().split()
        if len(input_data) < 2:
            # Handle case where input might be empty
            return
            
        nl = int(input_data[0])
        sl = int(input_data[1])
        
        result = solve(nl, sl)
        print(result)
        
    except EOFError:
        # Handle end of file if running interactively
        pass
    except Exception as e:
        # print(f"An error occurred: {e}", file=sys.stderr)
        pass

if __name__ == "__main__":
    main()