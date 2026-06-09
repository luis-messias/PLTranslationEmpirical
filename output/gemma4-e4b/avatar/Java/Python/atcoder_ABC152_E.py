import math
import sys

# Set up input reading from stdin
def get_input():
    data = sys.stdin.read().split()
    if not data:
        return 0, []
    
    N = int(data[0])
    A = [int(x) for x in data[1:N+1]]
    return N, A

def mod_pow(b, e, mod):
    """Calculates (b^e) % mod"""
    return pow(b, e, mod)

def mod_inv(x, mod):
    """Calculates modular inverse x^(-1) % mod using Fermat's Little Theorem"""
    # Since mod = 10^9 + 7 is prime
    return mod_pow(x, mod - 2, mod)

def mod_div(a, b, mod):
    """Calculates (a / b) % mod = (a * b^(-1)) % mod"""
    if b == 0:
        # Handle division by zero if necessary, though constraints usually prevent this
        raise ZeroDivisionError("Division by zero in modular arithmetic")
    return (a % mod * mod_inv(b, mod)) % mod

def solve():
    N, A = get_input()
    
    if N == 0:
        print(0)
        return

    # 1. Calculate LCM (L)
    lcm_val = 1
    for a_i in A:
        if a_i == 0:
            # If 0 is present, LCM is 0. This case