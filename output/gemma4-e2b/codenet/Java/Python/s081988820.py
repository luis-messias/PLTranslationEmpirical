import collections
import math

# --- Union-Find Data Structure (Implied by the context) ---
class UnionFind:
    """
    A basic implementation of the Union-Find data structure (Disjoint Set Union).
    """
    def __init__(self, n):
        # parent[i] stores the parent of element i
        self.parent = list(range(n))
        # rank[i] stores the rank (or height) of the tree rooted at i
        self.rank = [0] * n

    def find(self, i):
        """Find the representative (root) of the set containing i with path compression."""
        if self.parent[i] == i:
            return i
        self.parent[i] = self.find(self.parent[i])  # Path compression
        return self.parent[i]

    def union(self, i, j):
        """Unite the sets containing i and j by rank."""
        root_i = self.find(i)
        root_j = self.find(j)

        if root_i != root_j:
            # Union by rank
            if self.rank[root_i] < self.rank[root_j]:
                self.parent[root_i] = root_j
            elif self.rank[root_i] > self.rank[root_j]:
                self.parent[root_j] = root_i
            else:
                self.parent[root_j] = root_i
                self.rank[root_i] += 1
            return True
        return False

# --- Set Operations / Bitset Simulation (Implied by the context) ---
# The original code contained a class/structure for bitsets, which is often
# implemented using Python's native integers or specialized libraries for speed.
# Since the original code snippet didn't show the full context of how these
# structures interact, we'll keep the structure simple unless a specific
# operation is defined.

class BitSet:
    """
    A simple class to represent a set of boolean values, often used for
    bitset operations.
    """
    def __init__(self, size):
        self.size = size
        # Use a list of integers (or a single large integer) to store the bits
        self.data = [0] * size

    def set(self, index):
        if 0 <= index < self.size:
            self.data[index] = 1

    def get(self, index):
        if 0 <= index < self.size:
            return self.data[index] == 1
        return False

    def __repr__(self):
        return f"BitSet(size={self.size}, data={self.data})"

# --- The rest of the code structure (The specific algorithms) ---
# The original code snippet ended abruptly after defining the structures.
# If there were specific functions or main execution blocks, they would follow here.
# Since they are missing, the translation stops at the defined classes.

# Example of how the UnionFind might be used:
if __name__ == '__main__':
    print("--- UnionFind Example ---")
    uf = UnionFind(5)
    print(f"Find(0): {uf.find(0)}")
    print(f"Union(0, 1): {uf.union(0, 1)}")
    print(f"Find(1): {uf.find(1)}")
    print(f"Union(1, 2): {uf.union(1, 2)}")
    print(f"Find(0): {uf.find(0)}")
    print(f"Union(3, 4): {uf.union(3, 4)}")
    print(f"Find(0): {uf.find(0)}")