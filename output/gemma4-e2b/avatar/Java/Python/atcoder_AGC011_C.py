import sys

class Main:
    def __init__(self):
        # Initialize instance variables based on Java structure
        self.graph = []
        self.visited = []
        self.color = []
        self.one = 0
        self.bipartite = 0
        self.count = 0
        self.mujun = False

    def dfs(self, a: int, c: int) -> int:
        if self.visited[a]:
            # Check for conflict if already visited
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
        # Read input from stdin
        try:
            data = sys.stdin.read().split()
            if not data:
                return
            
            n = int(data[0])
            m = int(data[1])
            
            self.graph = [[] for _ in range(n)]
            
            data_idx = 2
            for _ in range(m):
                u = int(data[data_idx]) - 1
                v = int(data[data_idx + 1]) - 1
                self.graph[u].append(v)
                self.graph[v].append(u)
                data_idx += 2
        except Exception:
            # Handle potential reading errors if input format is unexpected
            return

        self.visited = [False] * n
        self.color = [-1] * n  # -1 represents uncolored
        
        self.one = 0
        self.bipartite = 0
        self.count = 0
        
        for i in range(n):
            if self.visited[i]:
                continue
            
            self.count += 1
            self.mujun = False
            
            # Start DFS for a new component, starting color 0
            kind = self.dfs(i, 0)
            
            if kind == 1:
                self.one += 1
            elif not self.mujun:
                self.bipartite += 1

        # Calculate the final result based on the formula
        # long total = one * ( 2 * n - one ) ;
        # total += ( count - one ) * ( count - one ) ;
        # total += bipartite * bipartite ;
        
        total = self.one * (2 * n - self.one)
        total += (self.count - self.one) * (self.count - self.one)
        total += self.bipartite * self.bipartite
        
        print(total)

if __name__ == "__main__":
    # The Java code starts a thread, but in a typical competitive programming context, 
    # we execute the logic directly.
    main_instance = Main()
    main_instance.run()