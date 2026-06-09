import sys

# Set up input reading function
def input():
    return sys.stdin.readline().strip()

class UnionFindTree:
    def __init__(self, n):
        self.n = n
        self.par = list(range(n))
        self.rank = [0] * n

    def find(self, x):
        if self.par[x] == x:
            return x
        # Path compression
        self.par[x] = self.find(self.par[x])
        return self.par[x]

    def unite(self, x, y):
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x == root_y:
            return

        # Union by rank
        if self.rank[root_x] < self.rank[root_y]:
            self.par[root_x] = root_y
        elif self.rank[root_x] > self.rank[root_y]:
            self.par[root_y] = root_x
        else:
            # Ranks are equal
            self.par[root_y] = root_x
            self.rank[root_x] += 1

    def same(self, x, y):
        return self.find(x) == self.find(y)

class AtcoderABC126E:
    def do_it(self):
        # Read N
        try:
            n_line = input()
            if not n_line:
                return
            n = int(n_line)
        except EOFError:
            return
        
        utf = UnionFindTree(n)
        
        # Read M
        try:
            m_line = input()
            if not m_line:
                m = 0
            else:
                m = int(m_line)
        except EOFError:
            m = 0

        # Process M edges
        for _ in range(m):
            try:
                line = input()
                if not line:
                    break
                x, y, z = map(int, line.split())
                
                # Indices are 1-based in input, convert to 0-based
                utf.unite(x - 1, y - 1)
            except EOFError:
                break
            except ValueError:
                # Handle case where line might be empty or malformed
                continue

        # Count connected components (number of roots)
        count = 0
        for i in range(n):
            # Check if i is the parent of itself (i.e., a root)
            # We must call find(i) first to ensure path compression updates the parent array
            # However, since we only care about the count of distinct roots, checking par[i] == i 
            # after all unions is sufficient if we assume the DSU structure is maintained correctly.
            # A safer way is to count how many elements are their own root after all operations.
            if utf.par[i] == i:
                count += 1
        
        print(count)

def main():
    solver = AtcoderABC126E()
    solver.do_it()

if __name__ == "__main__":
    main()