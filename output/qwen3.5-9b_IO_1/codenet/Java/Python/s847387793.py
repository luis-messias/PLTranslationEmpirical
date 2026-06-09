import sys

class FastScanner:
    def __init__(self):
        self.input = sys.stdin.read().split()
        self.pos = 0
    
    def next(self):
        if self.pos >= len(self.input):
            raise Exception("No more input")
        token = self.input[self.pos]
        self.pos += 1
        return token
    
    def nextInt(self):
        return int(self.next())

class Solver:
    def __init__(self, sc):
        self.sc = sc
        self.max = 0
        self.n = 0
        self.m = 0
        self.q = 0
        self.a = []
        self.b = []
        self.c = []
        self.d = []
    
    def run(self):
        self.n = self.sc.nextInt()
        self.m = self.sc.nextInt()
        self.q = self.sc.nextInt()
        self.a = [0] * self.q
        self.b = [0] * self.q
        self.c = [0] * self.q
        self.d = [0] * self.q
        for i in range(self.q):
            self.a[i] = self.sc.nextInt()
            self.b[i] = self.sc.nextInt()
            self.c[i] = self.sc.nextInt()
            self.d[i] = self.sc.nextInt()
        self.dfs([1])
        print(self.max)
    
    def dfs(self, array):
        if len(array) > self.n:
            score = 0
            for i in range(self.q):
                if array[self.b[i]] - array[self.a[i]] == self.c[i]:
                    score += self.d[i]
            self.max = max(self.max, score)
            return
        
        # Append an item to the existing array
        newArray = array + [array[-1]]
        
        while newArray[-1] <= self.m:
            self.dfs(newArray)
            newArray[-1] += 1

def main():
    sc = FastScanner()
    solver = Solver(sc)
    solver.run()

if __name__ == "__main__":
    main()
