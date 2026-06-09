import sys

def modinv(a, m):
    """Calculates the modular inverse of a modulo m using the Extended Euclidean Algorithm."""
    m0 = m
    t, q = 0, 1
    r, s = m, 0
    while a > 1:
        q = a // 1
        r, a = a % r, r
        t, s = s, t - q * s
    
    if r > 1:
        # This part handles the case where the original 'a' was not used correctly in the standard iterative EEA setup
        # Let's stick to the standard iterative implementation structure for clarity and correctness based on the Java code's intent.
        # The Java implementation seems to be a direct translation of the iterative EEA structure.
        pass

    # Reimplementing the provided Java logic structure for modinv:
    # The Java code uses a specific structure for EEA. We must ensure the Python version mirrors that logic exactly.
    
    # Standard iterative EEA implementation for finding inverse of a mod m
    m = m0
    t = 0
    q = 1
    r = m
    s = 0
    
    # We are finding x such that a*x = 1 (mod m)
    # Let's use the standard implementation structure for modular inverse:
    
    # a is the number we want to invert, m is the modulus
    
    # Initialize variables for Extended Euclidean Algorithm
    m_orig = m
    t_orig = 0
    q_orig = 1
    r_orig = m
    s_orig = 0
    
    # We want to find x such that a*x + m*y = gcd(a, m). If gcd(a, m) = 1, then x is the inverse.
    # The Java code seems to implement the specific iterative swap logic.
    
    # Let's use a simpler, robust implementation based on Fermat's Little Theorem if m is prime, or EEA if we must match the provided structure exactly.
    # Since the Java code explicitly implements EEA, we must translate that logic.
    
    # The provided Java modinv implementation is complex and relies on specific variable swapping.
    # Let's use a standard, cleaner EEA implementation for modular inverse, which is mathematically equivalent and safer in Python, 
    # unless strict byte-for-byte translation of the variable flow is required.
    
    # Given the context of competitive programming, we assume the provided Java implementation is correct for the intended purpose.
    
    # Standard EEA implementation:
    x, y = 0, 1
    if m == 1:
        return 0
    
    # We are finding inverse of 'a' mod 'm'
    a_val = a % m
    m_val = m
    
    # Ensure a_val is positive
    if a_val < 0:
        a_val += m_val
        
    # Extended Euclidean Algorithm
    r0, r1 = m_val, a_val
    x0, x1 = 1, 0
    
    while r1 != 0:
        q_val = r0 // r1
        r0, r1 = r1, r0 - q_val * r1
        x0, x1 = x1, x0 - q_val * x1
        
    # r0 is gcd(a, m). If r0 != 1, inverse does not exist.
    if r0 != 1: