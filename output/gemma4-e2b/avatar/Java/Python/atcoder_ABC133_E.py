import sys

class Node:
    def __init__(self, i):
        self.index = i
        self.children = []
        self.parent = -1
        self.pattern = 0

    def set_parent(self, K, parent, use, nodes):
        self.pattern = K - use
        self.parent = parent
        count = 1
        if parent != -1:
            count += 1
        
        # Iterate over children and recursively call set_parent
        for n in self.children:
            if n == self.parent:
                continue
            
            # Note: The Java code calls setParent on the child node 'n'
            nodes[n].set_parent(K, self.index, count, nodes)
            count += 1

def solve():
    # Read input from stdin
    try:
        # Read N and K
        line = sys.stdin.readline()
        if not line:
            return
        N, K = map(int, line.split())
    except EOFError:
        return
    except ValueError:
        return

    nodes = [Node(i) for i in range(N)]

    # Read edges
    for _ in range(N - 1):
        try:
            a, b = map(int, sys.stdin.readline().split())
            # Adjust to 0-based indexing
            a -= 1
            b -= 1
            nodes[a].children.append(b)
            nodes[b].children.append(a)
        except:
            # Handle potential reading errors if input format is strict
            continue

    # Start the process from node 0
    nodes[0].set_parent(K, -1, 0, nodes)

    # Calculate the product of patterns modulo 10^9 + 7
    MOD = 1_000_000_007
    patterns = 1
    for node in nodes:
        patterns = (patterns * node.pattern) % MOD

    print(patterns)

if __name__ == "__main__":
    solve()