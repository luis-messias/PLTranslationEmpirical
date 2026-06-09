import sys

class Codeforces_216_B:
    def __init__(self):
        self.count = 0
        self.cycle = 1
        self.path = 0
        self.graph = []
        self.seen = []

    def dfs(self, child, par):
        if self.seen[child]:
            return self.cycle
        self.seen[child] = True
        self.count += 1
        
        # graph is 1-indexed based on how it's populated in main, but Python lists are 0-indexed.
        # We assume graph indices correspond to vertex numbers.
        
        # Iterate over neighbors of child
        if child < len(self.graph):
            for neighbor in self.graph[child]:
                if neighbor != par:
                    if self.dfs(neighbor, child) == self.cycle:
                        return self.cycle
        return self.path

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Input parsing
    m = int(data[0])
    n = int(data[1])
    
    # Initialize structure
    ft = Codeforces_216_B()
    
    # Initialize graph (m+1 lists, index 0 unused or used for 1-based indexing)
    # Java used m+1 size for seen array and m+1 lists for graph.
    ft.graph = [[] for _ in range(m + 1)]
    ft.seen = [False] * (m + 1)

    data_idx = 2
    
    # Read edges
    for _ in range(n):
        if data_idx + 1 < len(data):
            x = int(data[data_idx])
            y = int(data[data_idx + 1])
            
            # Add edges (undirected)
            ft.graph[x].append(y)
            ft.graph[y].append(x)
            
            data_idx += 2
        else:
            break

    toremove = 0
    
    # Run DFS for each unvisited component
    for i in range(1, m + 1):
        if not ft.seen[i]:
            ft.count = 0
            # Start DFS. Parent is 0 (dummy parent)
            result = ft.dfs(i, 0)
            
            if result == ft.cycle:
                if ft.count % 2 == 1:
                    toremove += 1

    # Final adjustment
    if (m - toremove) % 2 == 1:
        toremove += 1
        
    print(toremove)

solve()
