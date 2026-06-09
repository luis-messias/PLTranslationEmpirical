import sys
import math

# Set recursion limit higher for potential deep recursive calls (though not strictly necessary for this specific math)
# sys.setrecursionlimit(2000)

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def fast_pow(base, n, M):
    if n == 0:
        return 1
    if n == 1:
        return base % M
    
    halfn = fast_pow(base, n // 2, M)
    
    if n % 2 == 0:
        return (halfn * halfn) % M
    else:
        return ((halfn * halfn) % M * base) % M

def modInverse(n, M):
    # Using Fermat's Little Theorem: a^(M-2) % M is the inverse of a mod M, assuming M is prime
    return fast_pow(n, M - 2, M)

def is_prime(n):
    if n <= 1:
        return False
    if n <= 3:
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # The input reading logic in the Java code implies reading pairs of long values (n, m)
    # We iterate through the data, assuming n and m are provided sequentially.
    
    # Since the Java code structure implies reading multiple test cases, 
    # we process the data sequentially.
    
    data_ptr = 0
    
    # The Java code structure suggests reading N and M pairs.
    # We assume the input stream provides N, M, N, M, ...
    
    while data_ptr + 1 < len(data):
        try:
            n = int(data[data_ptr])
            m = int(data[data_ptr + 1])
            data_ptr += 2
        except IndexError:
            break
        except ValueError:
            # Handle case where data might not be convertible to int if input format is complex
            break

        if n == 0:
            print(0)
            continue
        
        if n == m:
            print(0)
            continue
        
        if n > m:
            # n = m + (n % m) - m  => n = n % m
            n_mod_m = n % m
            # The Java code calculated:
            # n = m + n % m;
            # n -= m;
            # This simplifies to n = n % m
            
            # Then it printed Math.min(m-n, n)
            # If n = n % m:
            result = min(m - n, n)
            print(result)
            continue
        
        # n < m
        # Result: Math.min(m-n, n)
        result = min(m - n, n)
        print(result)

# Execute the solve function
solve()