import sys

class Node:
    def __init__(self, i):
        self.index = i
        self.pattern = 0
        self.children = []
        self.parent = -1
    
    def setParent(self, K, parent, use, nodes):
        self.pattern = K - use
        self.parent = parent
        count = 1
        if parent != -1:
            count += 1
        for n in self.children:
            if n == parent:
                continue
            nodes[n].setParent(K, self.index, count, nodes)
            count += 1

def solve():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    N = int(next(iterator))
    K = int(next(iterator))
    
    nodes = [Node(i) for i in range(N)]
    
    for _ in range(N - 1):
        a = int(next(iterator)) - 1
        b = int(next(iterator)) - 1
        nodes[a].children.append(b)
        nodes[b].children.append(a)
    
    nodes[0].setParent(K, -1, 0, nodes)
    
    patterns = 1
    for i in range(N):
        patterns = (patterns * nodes[i].pattern) % 1_000_000_007
    
    print(patterns)

if __name__ == "__main__":
    solve()