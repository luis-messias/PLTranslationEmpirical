from collections import defaultdict, deque

class Graph:
    def __init__(self, n):
        self.n = n
        self.graph = [[] for _ in range(n + 1)]
        self.seen = [False] * (n + 1)
        self.count = 0

    def dfs(self, child, par):
        if self.seen[child]:
            return 2
        self.seen[child] = True
        for i in self.graph[child]:
            if i != par:
                self.count += 1
                if self.dfs(i, child) == 2:
                    return 2
        return 0

    def solve(self):
        m, n = map(int, input().split())
        for _ in range(m + 1):
            self.graph.append([])
        for _ in range(n):
            x, y = map(int, input().split())
            self.graph[x].append(y)
            self.graph[y].append(x)

        toremove = 0
        for i in range(1, m + 1):
            if not self.seen[i]:
                self.count = 0
                if self.dfs(i, 0) == 2:
                    if self.count % 2 == 1:
                        toremove += 1

        if (m - toremove) % 2 == 1:
            toremove += 1
        print(toremove)


if __name__ == "__main__":
    g = Graph(int(input()))
    g.solve()