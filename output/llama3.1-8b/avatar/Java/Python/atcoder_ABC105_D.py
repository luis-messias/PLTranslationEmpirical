import sys
from collections import defaultdict

class InputReader:
    def __init__(self, stream):
        self.stream = stream
        self.st = ""

    def next(self):
        while not self.st:
            try:
                self.st = self.stream.readline().split()
            except Exception as e:
                raise EOFError from e
        return self.st.pop(0)

    def nextInt(self):
        return int(self.next())

    def nextIntArray(self, n):
        return [self.nextInt() for _ in range(n)]

class TaskD:
    def solve(self, testNumber, in_reader, out):
        n = in_reader.nextInt()
        m = in_reader.nextInt()
        a = in_reader.nextIntArray(n)
        dp = defaultdict(int)
        ans = 0
        base = 0

        for i in range(n):
            base = (base - a[i] % m + m) % m
            dp[(base + a[i]) % m] += 1
            ans += dp[base]

        out.write(str(ans))
        out.write("\n")

def main():
    input_stream = sys.stdin
    output_stream = sys.stdout

    in_reader = InputReader(input_stream)
    out = sys.stdout

    task_d = TaskD()
    task_d.solve(1, in_reader, out)

if __name__ == "__main__":
    main()