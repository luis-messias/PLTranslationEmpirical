import sys

class FastScanner:
    def __init__(self):
        self.br = sys.stdin

    def next(self):
        while True:
            try:
                return next(self.st)
            except StopIteration:
                self.st = iter(self.br.readline().split())

    def nextByte(self):
        return int(self.next())

    def nextShort(self):
        return int(self.next())

    def nextInt(self):
        return int(self.next())

    def nextLong(self):
        return int(self.next())

    def nextDouble(self):
        return float(self.next())

class codeforces_608_A:
    @staticmethod
    def main():
        in_ = FastScanner()
        n, s = in_.nextInt(), in_.nextInt()
        max_val = 0
        while n > 0:
            f, t = in_.nextInt(), in_.nextInt()
            if max_val < f + t:
                max_val = f + t
            n -= 1
        print(max(max_val, s))

if __name__ == "__main__":
    codeforces_608_A.main()