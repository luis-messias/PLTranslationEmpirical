import math

# ==============================================================================
# 1. UnionFind (Disjoint Set Union)
# ==============================================================================

class UnionFind:
    """
    Implements the Union-Find data structure with path compression and union by rank.
    """
    def __init__(self, n):
        # parent[i] stores the parent of element i
        self.parent = list(range(n))
        # rank[i] stores the rank (or height estimate) of the tree rooted at i
        self.rank = [0] * n

    def find(self, i):
        """Finds the representative (root) of the set containing element i with path compression."""
        if self.parent[i] == i:
            return i
        # Path compression: set the parent of i directly to the root
        self.parent[i] = self.find(self.parent[i])
        return self.parent[i]

    def union(self, i, j):
        """Unites the sets containing elements i and j by rank."""
        root_i = self.find(i)
        root_j = self.find(j)

        if root_i != root_j:
            # Union by rank: attach the smaller rank tree under the root of the deeper tree
            if self.rank[root_i] < self.rank[root_j]:
                self.parent[root_i] = root_j
            elif self.rank[root_i] > self.rank[root_j]:
                self.parent[root_j] = root_i
            else:
                # Ranks are equal, choose one as root and increment its rank
                self.parent[root_j] = root_i
                self.rank[root_i] += 1
            return True  # Union occurred
        return False # Already in the same set

# ==============================================================================
# 2. LongBitSet (Simulated using Python integers)
# ==============================================================================

class LongBitSet:
    """
    A simulation of a fixed-size bitset using Python's arbitrary precision integers.
    This class mimics the functionality of setting, getting, and counting bits.
    """
    def __init__(self, size=64):
        self.size = size
        self.bits = 0  # Using a single integer to store the bits

    def set(self, index, value=1):
        """Sets the bit at 'index' to 'value' (1 or 0)."""
        if index < 0 or index >= self.size:
            raise IndexError("Index out of bounds for the defined size.")
        
        if value == 1:
            self.bits |= (1 << index)
        elif value == 0:
            self.bits &= ~(1 << index)
        else:
            raise ValueError("Value must be 0 or 1.")

    def get(self, index):
        """Returns the value (0 or 1) of the bit at 'index'."""
        if index < 0 or index >= self.size:
            raise IndexError("Index out of bounds for the defined size.")
        return (self.bits >> index) & 1

    def count(self):
        """Counts the number of set bits (population count)."""
        return bin(self.bits).count('1')

    def __repr__(self):
        return f"LongBitSet(size={self.size}, count={self.count()})"

# ==============================================================================
# 3. ArrayUtils (Utility methods for arrays/lists)
# ==============================================================================

class ArrayUtils:
    """
    Utility class for common array/list operations.
    """
    @staticmethod
    def get_min(arr):
        """Returns the minimum value in the array."""
        if not arr:
            raise ValueError("Array cannot be empty.")
        return min(arr)

    @staticmethod
    def get_max(arr):
        """Returns the maximum value in the array."""
        if not arr:
            raise ValueError("Array cannot be empty.")
        return max(arr)

    @staticmethod
    def get_sum(arr):
        """Returns the sum of all elements in the array."""
        return sum(arr)

    @staticmethod
    def get_product(arr):
        """Returns the product of all elements in the array."""
        if not arr:
            return 1 # Product of empty set is 1
        result = 1
        for x in arr:
            result *= x
        return result

# ==============================================================================
# 4. Main Execution Block (Demonstration)
# ==============================================================================

def demonstrate_utilities():
    print("="*50)
    print("DEMONSTRATING UTILITIES")
    print("="*50)

    # --- UnionFind Demo ---
    print("\n--- UnionFind Demo ---")
    uf = UnionFind(5)
    print(f"Initial state: {uf.parent}")
    
    uf.union(0, 1)
    uf.union(2, 3)
    uf.union(1, 3) # Connects {0, 1} and {2, 3}
    
    print(f"After unions: {uf.parent}")
    print(f"Find(0) = {uf.find(0)}")
    print(f"Find(2) = {uf.find(2)}")
    
    # --- LongBitSet Demo ---
    print("\n--- LongBitSet Demo ---")
    bitset = LongBitSet(size=10)
    
    bitset.set(0, 1)
    bitset.set(5, 1)
    bitset.set(9, 1)
    
    print(f"Initial Bitset: {bitset}")
    print(f"Get(5): {bitset.get(5)}")
    
    bitset.set(0, 0) # Clear bit 0
    print(f"After clearing bit 0: {bitset}")
    print(f"Count: {bitset.count()}")

    # --- ArrayUtils Demo ---
    print("\n--- ArrayUtils Demo ---")
    data = [10, 20, 5, 30]
    print(f"Data set: {data}")
    print(f"Min: {ArrayUtils.get_min(data)}")
    print(f"Max: {ArrayUtils.get_max(data)}")
    print(f"Sum: {ArrayUtils.get_sum(data)}")
    print(f"Product: {ArrayUtils.get_product(data)}")
    
    empty_data = []
    print(f"Product of empty list: {ArrayUtils.get_product(empty_data)}")


if __name__ == "__main__":
    demonstrate_utilities()