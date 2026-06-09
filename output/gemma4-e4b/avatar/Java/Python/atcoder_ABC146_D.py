import sys

# Set recursion limit higher for deep DFS traversals
sys.setrecursionlimit(200000)

class Edge:
    def __init__(self, edge_id, to):
        self.id = edge_id
        self.to = to

class Solver:
    def __init__(self):
        self.n = 0
        self.g = []
        self.ans = []

    def dfs(self, to, color, parents):
        k = 1
        for e in self.g[to]:
            if e.to == parents:
                continue
            
            # Java logic: if ( k == color ) k ++ ;
            if k == color:
                k += 1
            
            self.ans[e.id] = k
            
            # Recursive call: pass the current assigned value k as the new starting color
            self.dfs(e.to, k, to)
            
            k += 1

    def solve(self):
        # Read input from stdin
        input_data = sys.stdin.read().split()
        if not input_data:
            return

        # N is the first element
        self.n = int(input_data[0])
        
        # Initialize graph and adjacency list
        self.g = [[] for _ in range(self.n)]
        
        # Edges start from index 1 in input_data
        input_index = 1
        
        # Read N-1 edges
        for i in range(self.n - 1):
            # Nodes are 1-indexed in input, convert to 0-indexed
            a = int(input_data[input_index]) - 1
            b = int(input_data[input_index + 1]) - 1
            input_index += 2
            
            # Add edges (undirected)
            self.g[a].append(Edge(i, b))
            self.g[b].append(Edge(i, a))

        # Initialize answer array
        self.ans = [0] * (self.n - 1)
        
        # Start DFS from node 0. Initial color and parent are -1.
        # Note: The Java code uses -1 for both color and parent in the initial call.
        self.dfs(0, -1, -1)
        
        # Calculate max
        max_val = 0
        if self.ans:
            max_val = max(self.ans)
        
        # Output results
        print(max_val)
        for c in self.ans:
            print(c)

if __name__ == "__main__":
    solver = Solver()
    solver.solve()