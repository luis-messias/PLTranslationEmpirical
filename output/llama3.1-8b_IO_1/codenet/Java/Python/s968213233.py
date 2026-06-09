import sys
from typing import List, Tuple
import heapq

class FastScanner:
    def __init__(self, stream):
        self.stream = stream
        self.buf = bytearray(1024)
        self.curChar = 0
        self.numChars = 0

    def read(self) -> int:
        if self.numChars == -1:
            raise ValueError()
        if self.curChar >= self.numChars:
            try:
                self.stream.readinto(self.buf)
                self.numChars = len(self.buf)
            except Exception as e:
                raise ValueError() from e
            if self.numChars <= 0:
                return -1
        return self.buf[self.curChar]

    def isSpaceChar(self, c: int) -> bool:
        return c == ' ' or c == '\n' or c == '\r' or c == '\t' or c == -1

    def nextInt(self) -> int:
        return int(self.next())

    def nextLong(self) -> int:
        return int(self.next())

    def nextDouble(self) -> float:
        return float(self.next())

    def next(self) -> str:
        c = self.read()
        while self.isSpaceChar(c):
            c = self.read()
        res = ''
        while not self.isSpaceChar(c):
            res += chr(c)
            c = self.read()
        return res

class Main:
    def __init__(self, in_stream: FastScanner, out_stream: sys.stdout, test: int):
        N = in_stream.nextInt()
        A = [in_stream.nextInt() for _ in range(N)]
        A.sort()

        res = 0
        q = []
        heapq.heappush(q, (A[-1], A[-1]))
        for i in range(N-2, -1, -1):
            a = A[i]
            place = heapq.heappop(q)
            res += min(place[0], place[1])
            heapq.heappush(q, (place[0], a))
            heapq.heappush(q, (a, place[1]))
        print(res, file=out_stream)

if __name__ == "__main__":
    in_stream = FastScanner(sys.stdin)
    out_stream = sys.stdout
    for _ in range(1):
        Main(in_stream, out_stream, 1)
