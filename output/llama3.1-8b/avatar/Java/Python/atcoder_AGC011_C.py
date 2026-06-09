from collections import defaultdict

class Main:
    def __init__(self):
        self.graph = defaultdict(list)
        self.visited = [False] * 1000
        self.color = [-1] * 1000
        self.one = 0
        self.bipartite = 0
        self.count = 0

    def dfs(self, a, c):
        if self.visited[a]:
            if self.color[a] >= 0 and self.color[a] != c:
                return False
            return True
        self.visited[a] = True
        self.color[a] = c
        total = 1
        for b in self.graph[a]:
            total += self.dfs(b, 1 - c)
        return total

    def run(self):
        n = int(input())
        m = int(input())
        for i in range(n):
            self.graph[i] = []
        for _ in range(m):
            u = int(input()) - 1
            v = int(input()) - 1
            self.graph[u].append(v)
            self.graph[v].append(u)

        for i in range(n):
            if not self.visited[i]:
                self.count += 1
                self.mujun = False
                kind = self.dfs(i, 0)
                if kind == 1:
                    self.one += 1
                elif not self.mujun:
                    self.bipartite += 1

        total = self.one * (2 * n - self.one) + (self.count - self.one) ** 2 + self.bipartite ** 2
        print(total)

if __name__ == "__main__":
    main_thread = Main()
    main_thread.run()