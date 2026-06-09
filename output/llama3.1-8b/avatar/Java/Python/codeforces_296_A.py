import sys
from collections import defaultdict

class Task:
    def solve(self, in_, out):
        n = int(in_.next())
        array = [0] * 1001
        for _ in range(n):
            index = int(in_.next())
            array[index] += 1
        count_max = -1
        for i in range(1, len(array)):
            if count_max < array[i]:
                count_max = array[i]
        if n % 2 == 0:
            if count_max <= n // 2:
                out.write("YES\n")
            else:
                out.write("NO\n")
        else:
            if count_max <= n // 2 + 1:
                out.write("YES\n")
            else:
                out.write("NO\n")

class InputReader:
    def __init__(self, stream):
        self.reader = sys.stdin

    def next(self):
        return next(self.reader).strip()

    def next_int(self):
        return int(self.next())

    def next_long(self):
        return int(self.next())

    def next_double(self):
        return float(self.next())

def main():
    in_ = InputReader(sys.stdin)
    out = sys.stdout
    task = Task()
    task.solve(in_, out)

if __name__ == "__main__":
    main()