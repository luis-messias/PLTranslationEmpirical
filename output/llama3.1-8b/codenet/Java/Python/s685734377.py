import sys
from collections import defaultdict

class FastScanner:
    def __init__(self, in_stream):
        self.br = in_stream
        self.st = None

    def nextInt(self):
        return int(self.next())

    def next(self):
        while self.st is None or not self.st:
            line = None
            try:
                line = next(self.br)
            except StopIteration:
                pass
            self.st = line.split()
        return self.st.pop(0)

def main():
    in_stream = sys.stdin
    out_stream = sys.stdout

    fs = FastScanner(in_stream)
    pw = PrintWriter(out_stream, flush=True)

    solver = TaskB()
    solver.solve(1, fs, pw)
    pw.close()

class TaskB:
    def solve(self, testNumber, fs, pw):
        n = fs.nextInt()
        a = [[char for char in fs.next()] for _ in range(n)]

        P = 37
        Q = 47

        powP = [1]
        powQ = [1]

        for i in range(1, n + 1):
            powP.append(powP[-1] * P)
            powQ.append(powQ[-1] * Q)

        hashRow = [[0] * n for _ in range(n)]
        hashCol = [[0] * n for _ in range(n)]

        for i in range(n):
            for j in range(n):
                for k in range(n):
                    hashRow[i][k] += a[i][j] * powP[(j - k + n) % n]
                    hashCol[j][k] += a[i][j] * powP[(i - k + n) % n]

        ans = 0
        for A in range(n):
            for B in range(n):
                ok = True
                for i in range(n):
                    if hashRow[(i + A) % n][B] != hashCol[(i + B) % n][A]:
                        ok = False
                        break
                ans += 1 if ok else 0

        pw.println(ans)

if __name__ == "__main__":
    main()