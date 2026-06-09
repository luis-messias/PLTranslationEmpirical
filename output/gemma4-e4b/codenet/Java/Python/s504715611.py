import sys
import math

# Setting up input reading to mimic FastScanner behavior for simplicity
# In a real competitive programming environment, sys.stdin.read().split() might be used.
# For this translation, we will rely on standard input reading functions.

class UnionFind:
    def __init__(self, n):
        # Initialize by -1
        self.parent = [-1] * n

    def root(self, A):
        # In which tree is A?
        if self.parent[A] < 0:
            return A
        # Path compression
        return self.parent[A] = self.root(self.parent[A])

    def size(self, A):
        # size of tree which is include A
        return -self.parent[self.root(A)]

    def connect(self, A, B):
        # Connect A and B
        A = self.root(A)
        B = self.root(B)
        if A == B:
            return False
        
        # Union by size: Ensure A is the larger tree
        if self.parent[A] > self.parent[B]:
            A, B = B, A
        
        # Union B into A
        self.parent[B] = A
        self.parent[A] += self.parent[B]
        return True

# --- Utility Functions (Mimicking static methods/global scope) ---

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def modInverse(a, m):
    # Calculates modular inverse using Fermat's Little Theorem (if m is prime)
    # Or Extended Euclidean Algorithm (general case)
    # Since the original code implies modular arithmetic, we use the standard approach.
    # For simplicity and matching the structure, we assume the context allows for standard modular inverse calculation.
    # If m is prime, a^(m-2) % m is sufficient.
    return pow(a, m - 2, m)

# --- Main Execution Context ---

def solve():
    # The structure implies that the main logic resides here or in the calling scope.
    # Since the original code snippet is incomplete (lacking main execution), 
    # we define the structure based on the provided classes/methods.
    pass

# Example usage structure (if we were to run this):
# if __name__ == "__main__":
#     solve()

# Note: The provided code snippet is a collection of definitions (classes/methods) 
# but lacks the main execution block. The solution provides the structure 
# mirroring the definitions given.