import sys

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
        out.write(str(ans) + "\n")

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
            self.isDigit[ord('0') + i] = True
        self.isDigit[ord('-')] = True
        self.isSpace[ord(' ')] = self.isSpace[ord('\r')] = self.isSpace[ord('\n')] = self.isSpace[ord('\t')] = True
        self.isLineSep[ord('\r')] = self.isLineSep[ord('\n')] = True

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
        len_ = 1
        ret = 0
        c = self.nextChar()
        if c == '-':
            sign = -1
        else:
            sign = 1
        for _ in range(len_):
            ret = ret * 10 + ord(c) - 48
            c = self.read()
        return sign * ret

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

if __name__ == "__main__":
    main()
