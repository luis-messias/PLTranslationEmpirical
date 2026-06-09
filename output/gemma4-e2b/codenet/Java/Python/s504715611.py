import sys
import math

# Set recursion limit higher for potential deep recursion in UnionFind or other functions
sys.setrecursionlimit(2000)

class UnionFind:
    def __init__(self, n):
        self.parent = [-1] * n

    def root(self, A):
        # In which tree is A? (Find with path compression)
        if self.parent[A] < 0:
            return A
        self.parent[A] = self.root(self.parent[A])
        return self.parent[A]

    def size(self, A):
        # size of tree which is include A
        root_A = self.root(A)
        # The Java implementation returns -Parent[root(A)], implying Parent stores negative size.
        return -self.parent[root_A]

    def connect(self, A, B):
        # Connect A and B (Union by size)
        A_root = self.root(A)
        B_root = self.root(B)

        if A_root == B_root:
            return False

        # Union by size: Attach smaller tree to larger tree
        size_A = self.size(A_root)
        size_B = self.size(B_root)

        if size_A < size_B:
            A_root, B_root = B_root, A_root  # Swap roots to ensure A_root is the larger one
            size_A, size_B = size_B, size_A

        # Attach B_root to A_root
        self.parent[B_root] = A_root
        self.parent[A_root] += self.parent[B_root]  # Update size (since parent stores negative size)
        
        return True

# --- Utility Functions ---

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def lcm(a, b):
    if a == 0 or b == 0:
        return 0
    return abs(a * b) // gcd(a, b)

def modint(a, m):
    # Implements the extended Euclidean algorithm logic from the Java code
    b, u, v = m, 1, 0
    while b != 0:
        t = a // b
        a -= t * b
        x = a
        a = b
        b = x

        u -= t * v
        x = u
        u = v
        v = x
    
    u %= m
    if u < 0:
        u += m
    return u

def max_size(a, b):
    return max(a, b)

# --- Input/Output Handling (Simplified for competitive programming style) ---

def solve():
    # In a real scenario, input would be read here.
    # Since the prompt didn't specify input format, we'll assume a placeholder structure.
    pass

# Note: Since the original prompt provided no specific input/output structure, 
# the provided code structure above is a direct translation of the mathematical/algorithmic 
# functions implied by the context, rather than a runnable program.