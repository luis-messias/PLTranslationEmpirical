import sys
from typing import List

class Scanner:
    def __init__(self, file):
        self.file = file
        self.index = 0
        self.tokens = []

    def next(self):
        while not self.tokens or self.index == len(self.tokens):
            line = self.file.readline()
            if not line:
                return None
            self.tokens = line.split()

        token = self.tokens[self.index]
        self.index += 1
        return token

    def nextInt(self):
        return int(self.next())

class Codeforces95A:
    def __init__(self):
        self.sc = Scanner(sys.stdin)
        self.out = sys.stdout

    def main(self):
        n = self.sc.nextInt()
        ss = [self.sc.next() for _ in range(n)]
        cc = self.sc.next()
        m = len(cc)
        c = self.sc.next()[0]
        a = 'b' if c == ord('a') else 'a'
        lucky = [False] * m

        for j in range(m):
            for i in range(n):
                l = len(ss[i])
                if m - j >= l and self.compare(cc, j, ss[i], 0, l) == 0:
                    for h in range(l):
                        lucky[j + h] = True

        for j in range(m):
            if lucky[j]:
                if ord(cc[j]) == ord(c):
                    cc = cc[:j] + (a if cc[j].isupper() else a) + cc[j+1:]
                else:
                    cc = cc[:j] + (c if cc[j].islower() else c) + cc[j+1:]

        self.out.write(cc)

    def compare(self, aa: List[str], i: int, bb: List[str], j: int, m: int) -> int:
        while m > 0:
            a = chr(aa[i]).upper()
            b = chr(bb[j]).upper()
            if a != b:
                return ord(a) - ord(b)
            i += 1
            j += 1
        return 0

if __name__ == "__main__":
    cf95a = Codeforces95A()
    cf95a.main()
