import sys
from typing import List, Tuple

class InputReader:
    def __init__(self):
        self.inp = sys.stdin.buffer.readline

    def readByte(self) -> int:
        byte = self.inp()
        if not byte:
            return -1
        return byte[0]

    def isSpaceChar(self, c: int) -> bool:
        return (c >= 33 and c <= 126)

    def skip(self) -> int:
        while True:
            b = self.readByte()
            if b != -1 and not self.isSpaceChar(b):
                break
        return b

    def next(self) -> str:
        b = self.skip()
        sb = []
        while True:
            if b == -1 or self.isSpaceChar(b):
                break
            sb.append(chr(b))
            b = self.readByte()
        return ''.join(sb)

    def nextInt(self) -> int:
        c = self.readByte()
        while True:
            if not (c >= 33 and c <= 126):
                raise Exception('InputMismatchException')
            if c == '-':
                minus = True
                c = self.readByte()
            elif str(c).isdigit():
                break
            else:
                c = self.readByte()
        res = 0
        while True:
            if not (c >= '0' and c <= '9'):
                raise Exception('InputMismatchException')
            res = res * 10 + int(c)
            c = self.readByte()
            if self.isSpaceChar(c):
                break
        return -res if minus else res

    def nextLong(self) -> int:
        c = self.readByte()
        while True:
            if not (c >= 33 and c <= 126):
                raise Exception('InputMismatchException')
            if c == '-':
                minus = True
                c = self.readByte()
            elif str(c).isdigit():
                break
            else:
                c = self.readByte()
        res = 0
        while True:
            if not (c >= '0' and c <= '9'):
                raise Exception('InputMismatchException')
            res = res * 10 + int(c)
            c = self.readByte()
            if self.isSpaceChar(c):
                break
        return -res if minus else res

    def toIntArray(self, n: int) -> List[int]:
        a = []
        for _ in range(n):
            a.append(self.nextInt())
        return a


class Main:
    INF = 2**31 // 2
    LINF = 2**63 // 2

    @staticmethod
    def sort(a: List[int]) -> None:
        for i in range(len(a) - 1, 0, -1):
            t = (int)(len(a) * (random.random()))
            a[i], a[t] = a[t], a[i]
        a.sort()

    @staticmethod
    def main() -> None:
        ir = InputReader()
        m = ir.nextInt()
        n = ir.nextInt()
        manju = ir.toIntArray(m)
        boxlen = [ir.nextInt() for _ in range(n)]
        boxcost = [ir.nextInt() for _ in range(n)]

        Main.sort(manju)

        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                len_ = min(i + boxlen[j], m)
                cnt = sum(manju[m - k - 1] for k in range(i, len_))
                dp[i][j] = max(dp[i][j],
                               dp[len_][j + 1] + cnt - boxcost[j])
                dp[i][j] = max(dp[i][j], dp[i][j + 1])

        print(dp[0][0])
        sys.stdout.flush()


if __name__ == '__main__':
    Main.main()
