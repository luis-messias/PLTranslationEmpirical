import sys
from collections import deque

class InputReader:
    def __init__(self, stream):
        self.reader = sys.stdin if stream == sys.stdin else open(stream)
        self.tokenizer = None

    def next(self):
        while not self.tokenizer or not self.tokenizer.has_more_tokens():
            try:
                self.tokenizer = self.reader.readline().split()
            except Exception as e:
                raise RuntimeError(e)
        return self.tokenizer.pop(0)

class CColoringColorfully:
    def solve(self, test_number, in_reader, out):
        x = in_reader.next()
        a = deque(x)
        b = deque(x)
        a1 = 0
        a2 = 0

        for i in range(1, len(x)):
            if a[i] == a[i - 1]:
                if a[i] == '1':
                    a[i] = '0'
                else:
                    a[i] = '1'
                a1 += 1

        for i in range(len(x) - 1, 0, -1):
            if b[i] == b[i - 1]:
                if b[i - 1] == '1':
                    b[i - 1] = '0'
                else:
                    b[i - 1] = '1'
                a2 += 1

        out.write(str(min(a1, a2)) + '\n')

def main():
    in_reader = InputReader(sys.stdin)
    out = sys.stdout
    solver = CColoringColorfully()
    solver.solve(1, in_reader, out)

if __name__ == "__main__":
    main()