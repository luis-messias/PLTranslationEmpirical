This solution translates the logic into idiomatic Python, maintaining the structure and functionality of the original Java/pseudo-code.

Since the original code relies on specific array manipulations (like using the root's parent pointer to store the size), the Python class structure below replicates that behavior for correctness.


class UnionFind:
    """
    Implements the Union-Find data structure with Path Compression and Union by Size.
    """
    def __init__(self, n):
        # parent[i] stores the parent of element i.
        # For the root of a set, parent[i] stores the negative size of the set.
        self.parent = list(range(n))
        # Initialize all sizes to -1 (indicating a root of size 1)
        for i in range(n):
            self.parent[i] = -1

    def find(self, i):
        """
        Finds the representative (root) of the set containing element i, 
        with Path Compression optimization.
        """
        if self.parent[i] < 0:
            # i is the root
            return i
        
        # Path Compression: Set the parent of i directly to the root
        root = self.find(self.parent[i])
        self.parent[i] = root
        return root

    def union(self, i, j):
        """
        Unites the sets containing elements i and j, using Union by Size.
        Returns True if a union occurred, False if they were already in the same set.
        """
        root_i = self.find(i)
        root_j = self.find(j)

        if root_i == root_j:
            return False  # Already in the same set

        # Union by Size: Attach the smaller tree to the root of the larger tree.
        # Since the root stores the negative size, the smaller size means the 
        # root value is closer to zero (less negative).
        
        # Check sizes: |root_i| vs |root_j|
        if self.parent[root_i] > self.parent[root_j]:
            # Set i's root (root_i) is smaller (more positive negative value)
            # Attach root_i to root_j
            self.parent[root_i] = root_j
            # Update the size of the new root (root_j)
            self.parent[root_j] += self.parent[root_i]
        else:
            # Set j's root (root_j) is smaller or equal
            # Attach root_j to root_i
            self.parent[root_j] = root_i
            # Update the size of the new root (root_i)
            self.parent[root_i] += self.parent[root_j]
        
        return True

# --- Example Usage ---
if __name__ == "__main__":
    # Initialize UnionFind for 5 elements (0 to 4)
    uf = UnionFind(5)
    
    print("Initial state (parent array):", uf.parent)
    
    # Union 0 and 1
    print("\n--- Union(0, 1) ---")
    uf.union(0, 1)
    print("Parent array after union:", uf.parent)
    
    # Union 2 and 3
    print("\n--- Union(2, 3) ---")
    uf.union(2, 3)
    print("Parent array after union:", uf.parent)

    # Union 1 and 4 (Connects {0, 1} to {4})
    print("\n--- Union(1, 4) ---")
    uf.union
