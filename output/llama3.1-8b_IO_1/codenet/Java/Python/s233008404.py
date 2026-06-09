import sys
import math

class Main:
    def __init__(self):
        self.colorMtr = []
        self.h = 0
        self.w = 0
        self.k = 0

    def solve(self):
        h, w, k = map(int, input().split())
        self.colorMtr = [list(input()) for _ in range(h)]

        hPattern = math.pow(2, h)
        wPattern = math.pow(2, w)

        ans = 0

        for i in range(int(hPattern)):
            for j in range(int(wPattern)):
                if self.judge(i, j):
                    ans += 1

        print(ans)

    def judge(self, hPattern, wPattern):
        hBitArr = [0] * self.h
        wBitArr = [0] * self.w

        for i in range(self.h):
            if (hPattern >> i) & 1:
                hBitArr[i] = 1

        for i in range(self.w):
            if (wPattern >> i) & 1:
                wBitArr[i] = 1

        black = 0

        for i in range(self.h):
            for j in range(self.w):
                if hBitArr[i] == 1 or wBitArr[j] == 1:
                    continue
                if self.colorMtr[i][j] == '#':
                    black += 1

        return black == self.k

    def pow(self, base, n):
        retVal = 1
        while n > 0:
            if (n & 1) == 1:
                retVal *= base
            n >>= 1
            base *= base
        return retVal


if __name__ == "__main__":
    mainObj = Main()
    mainObj.solve()
