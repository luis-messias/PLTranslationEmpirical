import sys

class Main:
    def __init__(self):
        # Increase recursion limit for deep DFS calls
        sys.setrecursionlimit(2000)
        self.graph = []
        self.visited = []
        self.color = []
        self.one = 0
        self.bipartite = 0
        self.count = 0
        self.mujun = False

    def dfs(self, a, c):
        if self.visited[a]:
            # Check for odd cycle condition
            if self.color[a] >= 0 and self.color[a] != c:
                self.mujun = True
            return 0

        self.visited[a] = True
        self.color[a] = c
        total = 1
        
        for b in self.graph[a]:
            total += self.dfs(b, 1 - c)
        
        return total

    def run(self):
        # Read N and M from standard input
        try:
            data = sys.stdin.read().split()
            if not data:
                return
            
            n = int(data[0])
            m = int(data[1])
        except Exception:
            return

        # Initialize graph
        self.graph = [[] for _ in range(n)]
        
        data_index = 2
        for _ in range(m):
            if data_index + 1 >= len(data):
                break
            
            # Nodes are 1-indexed in input, convert to 0-indexed
            u = int(data[data_index]) - 1
            v = int(data[data_index + 1]) - 1
            
            self.graph[u].append(v)
            self.graph[v].append(u)
            data_index += 2

        # Initialize state variables
        self.visited = [False] * n
        self.color = [-1] * n
        self.one = 0
        self.bipartite = 0
        self.count = 0
        self.mujun = False

        for i in range(n):
            if self.visited[i]:
                continue
            
            self.count += 1
            self.mujun = False
            
            # kind = total nodes in the component
            kind = self.dfs(i, 0)
            
            if kind == 1:
                self.one += 1
            elif not self.mujun:
                self.bipartite += 1

        # Calculate total
        total = self.one * (2 * n - self.one)
        total += (self.count - self.one) * (self.count - self.one)
        total += self.bipartite * self.bipartite
        
        print(total)

if __name__ == "__main__":
    Main().run()