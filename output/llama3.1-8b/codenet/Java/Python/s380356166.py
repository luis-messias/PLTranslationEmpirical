import sys
from collections import defaultdict

class Solver:
    def solve(self, testNumber, in_, out):
        ans = 0
        K = in_.nextInt()
        S = in_.nextInt()
        for x in range(K + 1):
            for y in range(K + 1):
                wk = S - x - y
                if 0 <= wk <= K:
                    ans += 1
        out.println(ans)

class MyInput:
    def __init__(self, is_):
        self.in_ = sys.stdin
        self.pos = 0
        self.readLen = 0
        self.buffer = [None] * (1024 * 8)
        self.str = [''] * (500 * 8 * 2)
        self.isDigit = [False] * 256
        self.isSpace = [False] * 256
        self.isLineSep = [False] * 256

        for i in range(10):
            self.isDigit['0' + i] = True
        self.isDigit['-'] = True
        self.isSpace[' '] = self.isSpace['\r'] = self.isSpace['\n'] = self.isSpace['\t'] = True
        self.isLineSep['\r'] = self.isLineSep['\n'] = True

    def read(self):
        if self.pos >= self.readLen:
            self.pos = 0
            try:
                self.readLen = self.in_.read(self.buffer)
            except Exception as e:
                raise RuntimeError()
            if self.readLen <= 0:
                raise MyInput.EndOfFileRuntimeException()
        return self.buffer[self.pos]

    def nextInt(self):
        len_ = 0
        len_ += 1
        i = 0
        ret = 0
        while True:
            c = self.nextChar()
            if not self.isSpace[c]:
                break
        if c == '-':
            i = 1
        for _ in range(len_):
            ret = ret * 10 + ord(c) - 48
            c = self.read()
        if c == '-':
            ret = -ret
        return ret

    def nextChar(self):
        while True:
            c = self.read()
            if not self.isSpace[c]:
                return c

class MyInput_EndOfFileRuntimeException(Exception):
    pass

def main():
    solver = Solver()
    in_ = MyInput(sys.stdin)
    out = sys.stdout
    solver.solve(1, in_, out)
    out.close()

if __name__ == "__main__":
    main()