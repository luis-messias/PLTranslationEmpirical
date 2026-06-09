from collections import defaultdict, deque

class Node:
    def __init__(self, i):
        self.pattern = 0
        self.index = i
        self.children = []
        self.parent = -1

def solve():
    N = int(input())
    K = int(input())

    nodes = [Node(i) for i in range(N)]

    for _ in range(N-1):
        a, b = map(int, input().split()) - 1
        nodes[a].children.append(b)
        nodes[b].children.append(a)

    def dfs(node, parent, use, nodes):
        node.pattern = K - use
        node.parent = parent
        count = 1
        if parent != -1:
            count += 1
        for child in node.children:
            if child == parent:
                continue
            dfs(nodes[child], node.index, count, nodes)
            count += 1

    def read_ints():
        return map(int, input().split())

    a, b = next(read_ints()) - 1, next(read_ints()) - 1
    nodes[a].children.append(b)
    nodes[b].children.append(a)

    dfs(nodes[0], -1, 0, nodes)

    patterns = 1
    for i in range(N):
        patterns = (patterns * nodes[i].pattern) % 1000000007

    print(patterns)

solve()
