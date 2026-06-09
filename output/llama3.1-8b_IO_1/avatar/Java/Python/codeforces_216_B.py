from collections import defaultdict, deque

class Graph:
    def __init__(self):
        self.count = 0
        self.seen = [False]
        self.path = 0
        self.cycle = 1
        self.graph = [[]]

    def dfs(self, child, par):
        if self.seen[child]:
            return self.cycle
        self.seen.append(True)
        for i in self.graph[child]:
            if i != par:
                self.count += 1
                if self.dfs(i, child) == self.cycle:
                    return self.cycle
        return self.path

    def solve(self):
        m, n = map(int, input().split())
        self.seen = [False] * (m + 1)
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
                if self.dfs(i, 0) == self.cycle:
                    if self.count % 2 == 1:
                        toremove += 1

        if (m - toremove) % 2 == 1:
            toremove += 1
        print(toremove)


if __name__ == "__main__":
    g = Graph()
    g.solve()
