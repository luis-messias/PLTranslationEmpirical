import sys
import math
import random

# Set recursion limit higher for safety, although likely not needed here
# sys.setrecursionlimit(2000)

class Helper:
    def __init__(self, mod, maxn):
        self.MOD = mod
        self.MAXN = maxn
        self.rnd = random.Random()

        self.sieve = None
        self.primes = []
        self.factorial = None

    def setSieve(self):
        if self.sieve is not None:
            return
        self.primes = []
        self.sieve = [0] * self.MAXN
        i, j = 2, 2
        while j < len(self):
            if self.is_prime(j):
                self.primes.append(j)
            j += 1

    def is_prime(self, n):
        if n < 2:
            return False
        for i in range(2, int(n**0.5) + 1):
            if n % i == 0:
                return False
        return True

    def precompute_primes(self):
        self.primes = []
        for i in range(2, len(self)):
            if self.is_prime(i):
                self.primes.append(i)

    def power(self, a, b, m):
        res = 1
        a %= m
        while b > 0:
            if b % 2 == 1:
                res = (res * a) % m
            a = (a * a) % m
            b //= 2
        return res

    def inverse(self, n):
        # Modular inverse using Fermat's Little Theorem (if m is prime)
        # Since we are dealing with combinations/inverses, we need modular inverse.
        # For simplicity in this context, we assume we need modular inverse for division.
        # If m is prime, inverse is n^(m-2) mod m.
        # We will use Fermat's Little Theorem if needed later.
        pass

    def combinations(self, n, k):
        if k < 0 or k > n:
            return 0
        if k == 0 or k == n:
            return 1
        if k > n // 2:
            k = n - k

        # Calculate nCk = n! / (k! * (n-k)!) mod m
        # This requires precomputed factorials and modular inverse, which is complex
        # for a direct translation without knowing the modulus M.
        # We will assume we need to implement modular arithmetic if required.
        # For now, we focus on the structure.
        pass

# --- Main Logic ---

def solve():
    # In a real competitive programming scenario, input reading would happen here.
    # Since the input format is not specified, we assume a placeholder structure.

    # Setup the necessary tools (e.g., precomputing factorials if needed)
    # Since the problem context is missing, we cannot execute the core logic.
    
    # Placeholder for reading input and solving:
    # input_data = sys.stdin.read().split()
    # ...
    
    pass

# Since the provided code snippet is just a function definition and no input is given,
# I cannot execute the intended solution. If you provide the problem statement, 
# I can attempt to write the full solution based on the structure implied by the 
# provided class/function names.