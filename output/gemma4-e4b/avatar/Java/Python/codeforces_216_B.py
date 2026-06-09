import sys

class Codeforces216B:
    def __init__(self):
        self.count = 0
        self.seen = []
        self.path = 0
        self.cycle = 1
        self.graph = []

    def dfs(self, child, par):
        if self.seen[child]:
            return self.cycle
        
        self.seen[child] = True
        
        for neighbor in self.graph[child]:
            if neighbor != par:
                self.count += 1
                if self.dfs(neighbor, child) == self.cycle:
                    return self.cycle
        
        return self.path

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_index = 0
    
    # Read m (number of nodes) and n (number of edges)
    m = int(input_data[data_index])
    data_index += 1
    n = int(input_data[data_index])
    data_index += 1

    ft = Codeforces216B()
    
    # Initialize graph (m+1 size for 1-based indexing)
    ft.graph = [[] for _ in range(m + 1)]
    
    # Initialize seen array
    ft.seen = [False] * (m + 1)
    
    # Read edges
    for _ in range(n):
        x = int(input_data[data_index])
        data_index += 1
        y = int(input_data[data_index])
        data_index += 1
        
        ft.graph[x].append(y)
        ft.graph[y].append(x)

    toremove = 0
    
    # Iterate through nodes 1 to m
    for i in range(1, m + 1):
        if not ft.seen[i]:
            ft.count = 0
            # Check for cycle starting from i
            if ft.dfs(i, 0) == ft.cycle:
                # If a cycle is found, check parity of count
                if ft.count % 2 == 1:
                    toremove += 1
    
    # Final check based on total nodes m
    if (m - toremove) % 2 == 1:
        toremove += 1
    
    print(toremove)

if __name__ == "__main__":
    solve()