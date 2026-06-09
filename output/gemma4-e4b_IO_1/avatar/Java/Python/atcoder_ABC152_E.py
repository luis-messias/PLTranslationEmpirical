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
    if x == 0:
        # This should not happen if we assume a_i >= 1 for modular inverse
        raise ZeroDivisionError("Modular inverse undefined for 0")
    return mod_pow(x, mod - 2, mod)

def mod_div(a, b, mod):
    """Calculates (a / b) % mod = (a * b^(-1)) % mod"""
    if b == 0:
        # This case should be handled by input constraints or problem definition
        # Assuming
