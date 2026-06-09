import sys
from collections import defaultdict, deque
from typing import List, Tuple

class InputIterator:
    def __init__(self):
        self.input_line = []
        self.index = 0
        self.max = 0
        self.read = ''
        try:
            with open('input.txt', 'r') as f:
                while True:
                    line = f.readline()
                    if not line:
                        break
                    self.input_line.append(line.strip())
            self.max = len(self.input_line)
        except FileNotFoundError:
            pass

    def hasNext(self):
        return self.index < self.max

    def next(self):
        if self.hasNext():
            ret = self.input_line[self.index]
            self.index += 1
            return ret
        else:
            raise IndexError("There is no more input")

class PrintWriter:
    def __init__(self, file):
        self.file = file

    def print(self, obj):
        self.file.write(str(obj))

    def flush(self):
        self.file.flush()

def main():
    CONVSTR = defaultdict(lambda: ' ')
    CONVSTR[9] = '\n'
    CONVSTR[0] = ''
    if hasattr(sys, 'stdin'):
        ii = InputIterator()
    else:
        ii = None
    out = PrintWriter(sys.stdout)
    solve(out, ii)
    out.flush()

def solve(out, ii):
    N = int(ii.next()) if ii else 0
    list = [int(x) for x in input().split()] if ii else []
    max_val = 0
    output = 0
    for i in range(N):
        if max_val <= list[i]:
            max_val = list[i]
            output += 1
    print(output)

if __name__ == "__main__":
    main()
