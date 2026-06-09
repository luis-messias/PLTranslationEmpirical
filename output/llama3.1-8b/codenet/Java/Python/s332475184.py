from collections import defaultdict
import sys

class FastScanner:
    def __init__(self):
        self.inp = sys.stdin.readline

    def next(self):
        return self.inp()

    def next_int(self):
        return int(self.next())

    def next_long(self):
        return int(self.next())

    def next_double(self):
        return float(self.next())

class Main:
    def __init__(self):
        self.counter = [0] * n
        self.graph = defaultdict(list)

    def main(self):
        global n, q
        fs = FastScanner()
        n = fs.next_int()
        q = fs.next_int()

        for i in range(n-1):
            a = fs.next_int() - 1
            b = fs.next_int() - 1
            self.graph[a].append(b)
            self.graph[b].append(a)

        for i in range(q):
            v = fs.next_int() - 1
            w = fs.next_int()
            self.counter[v] += w

        self.dfs(0, -1, 0)
        print(*self.counter)

    def dfs(self, v, par, val):
        for i in self.graph[v]:
            if i != par:
                self.dfs(i, v, val + self.counter[v])
        self.counter[v] += val

if __name__ == "__main__":
    Main().main()