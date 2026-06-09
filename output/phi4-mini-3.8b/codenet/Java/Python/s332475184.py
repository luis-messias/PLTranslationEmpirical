import sys

class Main:
    def __init__(self):
        self.counter = [0] * n
        self.graph = [[] for _ in range(n)]

    def main(self, input_data=None):
        if input_data is None:
            reader = (line.strip() for line in sys.stdin)
        else:
            lines = iter(input_data.split('\n'))
        
        n, q = map(int, next(lines).split())
        self.graph = [[] for _ in range(n)]
        
        for i in range(1, n):
            a, b = map(lambda x: int(x) - 1, next(lines).strip().split())
            self.graph[a].append(b)
            self.graph[b].append(a)

        for i in range(q):
            v, val = (map(int, line.split()) for _ in iter(input_data))
            if input_data:
                self.counter[v-1] += val
            else:
                sys.stdin.readline()

        dfs(0, -1, 0)
        
        result = ' '.join(map(str, self.counter))
        print(result)

    def dfs(self, v, par, val):
        for i in self.graph[v]:
            if i != par:
                self.dfs(i, v, val + (self.counter[i] if input_data else -self.counter[i]))

if __name__ == "__main__":
    main = Main()