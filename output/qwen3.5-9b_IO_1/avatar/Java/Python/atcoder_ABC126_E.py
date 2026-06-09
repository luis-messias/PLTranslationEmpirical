import sys

class UnionFindTree:
    def __init__(self, n):
        self.n = n
        self.par = list(range(n))
        self.rank = [0] * n
    
    def find(self, x):
        if self.par[x] == x:
            return x
        else:
            self.par[x] = self.find(self.par[x])
            return self.par[x]
    
    def unite(self, x, y):
        x = self.find(x)
        y = self.find(y)
        if x == y:
            return
        if self.rank[x] < self.rank[y]:
            self.par[x] = y
        else:
            self.par[y] = x
            if self.rank[x] == self.rank[y]:
                self.rank[x] += 1
    
    def same(self, x, y):
        return self.find(x) == self.find(y)

def doIt():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    iterator = iter(input_data)
    n = int(next(iterator))
    m = int(next(iterator))
    
    utf = UnionFindTree(n)
    
    for _ in range(m):
        x = int(next(iterator)) - 1
        y = int(next(iterator)) - 1
        z = int(next(iterator))
        utf.unite(x, y)
    
    cnt = 0
    for i in range(n):
        if utf.par[i] == i:
            cnt += 1
    
    print(cnt)

if __name__ == "__main__":
    doIt()
