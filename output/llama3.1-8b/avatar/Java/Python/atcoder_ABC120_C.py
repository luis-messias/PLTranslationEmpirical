import sys
from collections import deque

class InputReader:
    def __init__(self, stream):
        self.reader = sys.stdin if stream == sys.stdin else open(stream)
        self.tokenizer = None

    def next(self):
        while not self.tokenizer or not self.tokenizer.hasMoreTokens():
            try:
                self.tokenizer = self.reader.readline().split()
            except Exception as e:
                raise RuntimeError(e)
        return self.tokenizer.pop(0)

class TaskB:
    def solve(self, testNumber, inReader, out):
        x = inReader.next()
        s = deque()
        c = 0
        for i in range(len(x)):
            s.append(x[i])
            while len(s) > 1:
                p = s.pop()
                q = s.pop()
                if (p == '1' and q == '0') or (p == '0' and q == '1'):
                    c += 1
                    continue
                else:
                    s.append(q)
                    s.append(p)
                    break
        print(c * 2)

def main():
    inReader = InputReader(sys.stdin)
    out = sys.stdout
    solver = TaskB()
    solver.solve(1, inReader, out)

if __name__ == "__main__":
    main()