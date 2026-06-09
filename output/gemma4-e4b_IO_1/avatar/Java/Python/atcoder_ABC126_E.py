import sys

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
        # Read all tokens from standard input
        data = sys.stdin.read().split()
        if not data:
            return

        # N is the first token
        n = int(data[0])
        
        # M is the second token
        m = int(data[1])
        
        utf = UnionFindTree(n)
        
        # Process M edges. Tokens start from index 2.
        edge_data_index = 2
        
        for i in range(m):
            # Check if enough tokens remain for x, y, z
            if edge_data_index + 2 >= len(data):
                break
            
            # x, y, z are read sequentially
            x = int(data[edge_data_index])
            y = int(data[edge_data_index + 1])
            z = int(data[edge_data_index + 2])
            
            # Indices are 1-based in input, convert to 0-based
            utf.unite(x - 1, y - 1)
            
            edge_data_index += 3

        # Count connected components
        count =
