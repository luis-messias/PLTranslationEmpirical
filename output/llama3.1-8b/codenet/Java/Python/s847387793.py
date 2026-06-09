import sys
from typing import List

class FastScanner:
    def __init__(self):
        self.in_stream = sys.stdin
        self.buffer = bytearray(1024)
        self.ptr = 0
        self.buflen = 0

    def hasNextByte(self) -> bool:
        if self.ptr < self.buflen:
            return True
        else:
            self.ptr = 0
            try:
                self.buflen = self.in_stream.read(self.buffer)
            except Exception as e:
                print(e)
            if self.buflen <= 0:
                return False
        return True

    def readByte(self) -> int:
        if self.hasNextByte():
            return self.buffer[self.ptr]
        else:
            return -1

    def isPrintableChar(self, c: int) -> bool:
        return 33 <= c and c <= 126

    def hasNext(self) -> bool:
        while self.hasNextByte() and not self.isPrintableChar(self.buffer[self.ptr]):
            self.ptr += 1
        return self.hasNextByte()

    def next(self) -> str:
        if not self.hasNext():
            raise NoSuchElementException()
        final_str = ""
        c = self.readByte()
        while self.isPrintableChar(c):
            final_str += chr(c)
            c = self.readByte()
        return final_str

    def nextLong(self) -> int:
        if not self.hasNext():
            raise NoSuchElementException()
        n = 0
        minus = False
        c = self.readByte()
        if c == ord('-'):
            minus = True
            c = self.readByte()
        if not (c >= ord('0') and c <= ord('9')):
            raise NumberFormatException()
        while True:
            if c >= ord('0') and c <= ord('9'):
                n *= 10
                n += c - ord('0')
            elif c == -1 or not self.isPrintableChar(c):
                return minus * n if minus else n
            else:
                raise NumberFormatException()
            c = self.readByte()

    def nextInt(self) -> int:
        nl = self.nextLong()
        if nl < -2**31 or nl > 2**31-1:
            raise NumberFormatException()
        return int(nl)

    def nextDouble(self) -> float:
        return float(self.next())

class Solver:
    def __init__(self, sc: FastScanner):
        self.sc = sc
        self.writer = sys.stdout

    def run(self):
        n = self.sc.nextInt()
        m = self.sc.nextInt()
        q = self.sc.nextInt()
        a = [0] * q
        b = [0] * q
        c = [0] * q
        d = [0] * q
        for i in range(q):
            a[i] = self.sc.nextInt()
            b[i] = self.sc.nextInt()
            c[i] = self.sc.nextInt()
            d[i] = self.sc.nextInt()
        self.dfs([1])
        print(max, file=self.writer)

    def dfs(self, array: List[int]):
        if len(array) > n:
            score = 0
            for i in range(q):
                if array[b[i]] - array[a[i]] == c[i]:
                    score += d[i]
            global max
            max = max(max, score)
            return
        # Append an item to the existing array
        new_array = [x for x in array] + [array[-1]]
        while new_array[-1] <= m:
            self.dfs(new_array)
            new_array[-1] += 1

if __name__ == "__main__":
    sc = FastScanner()
    try:
        with open("output.txt", "w") as w:
            Solver(sc).run()
    finally:
        sys.stdout.flush()