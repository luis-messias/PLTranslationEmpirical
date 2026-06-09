import sys

# Set recursion limit higher for safety, although this solution is iterative
# sys.setrecursionlimit(2000)

def extended_gcd(a, b):
    """Extended Euclidean Algorithm: returns (gcd, x, y) such that a*x + b*y = gcd."""
    if a == 0:
        return b, 0, 1
    gcd, x1, y1 = extended_gcd(b % a, a)
    x = y1 - (b // a) * x1
    y = x1
    return gcd, x, y

def modinv(a, m):
    """Calculates the modular inverse of a modulo m."""
    # We use the Extended Euclidean Algorithm
    gcd, x, y = extended_gcd(a, m)
    if gcd != 1:
        # Inverse does not exist (should not happen if m is prime and a < m)
        raise ValueError("Modular inverse does not exist")
    # x is the inverse, ensure it is positive
    return x % m

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    n = int(data[0])
    
    # A is the array of integers starting from the second element
    a = [int(x) for x in data[1:n+1]]

    MOD = 1000000007

    # 1. Calculate P = N! mod MOD
    p = 1
    for i in range(2, n + 1):
        p = (p * i) % MOD

    # 2. Calculate Q array
    # q[i] = sum_{j=1}^{i} modinv(j, MOD)
    q = [0] * n
    q[0] = 1  # q[0] = 1 (since the sum starts effectively from j=1, but the formula uses q[0]=1)
    
    # The Java loop calculates q[i] based on q[i-1] and modinv(i+1, mod)
    # q[i] = q[i-1] + modinv(i+1, mod)
    # Note: The index i in the loop runs from 1 to n-1.
    # The term added is modinv(i+1, mod).
    
    # Let's re-examine the Java loop indices carefully:
    # for ( int i = 1 ; i < n ; i ++ ) { q [ i ] = ( q [ i - 1 ] + modinv ( i + 1 , mod ) ) % mod ; }
    
    # If n=5:
    # i=1: q[1] = q[0] + modinv(2, mod)
    # i=2: q[2] = q[1] + modinv(3, mod)
    # i=3: q[3] = q[2] + modinv(4, mod)
    # i=4: q[4] = q[3] + modinv(5, mod)
    
    # This means q[i] = 1 + sum_{j=2}^{i+1} modinv(j, mod)
    
    # We need to calculate modinv(k, MOD) for k up to N+1.
    
    # Precalculate modular inverses needed for Q calculation
    # We need inverses for 2, 3, ..., N.
    
    # Since q[0] = 1, and the loop runs up to i=n-1, q will have n elements (indices 0 to n-1).
    
    # Let's adjust the calculation based on the indices used in the Java code:
    
    # q[0] = 1
    # For i = 1 to n-1: q[i] = q[i-1] + modinv(i+1, MOD)
    
    for i in range(1, n):
        # i+1 is the argument to modinv
        inv = modinv(i + 1, MOD)
        q[i] = (q[i - 1] + inv) % MOD

    # 3. Calculate
