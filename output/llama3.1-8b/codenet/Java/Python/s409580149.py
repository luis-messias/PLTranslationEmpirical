import sys
from typing import List, Tuple

mod = 10**9 + 7

def input():
    return sys.stdin.readline().strip()

def read_int():
    return int(input())

def read_long():
    return int(input())

def read_string():
    return input()

def read_int_array():
    return list(map(int, input().split()))

def read_long_array():
    return list(map(int, input().split()))

def read_string_array():
    return input().split()

class FastReader:
    def __init__(self):
        self.inbuf = []

    def read_byte(self):
        if not self.inbuf:
            try:
                self.inbuf = sys.stdin.buffer.read(1024)
            except EOFError:
                return -1
        if len(self.inbuf) == 0:
            return -1
        byte = self.inbuf[0]
        self.inbuf = self.inbuf[1:]
        return byte

    def is_space_char(self, c):
        return not (33 <= c <= 126)

    def skip(self):
        while True:
            b = self.read_byte()
            if b == -1 or not self.is_space_char(b):
                break
        return b

    def read_int(self):
        b = self.skip()
        if b == -1:
            raise EOFError
        result = 0
        sign = 1
        while True:
            if '0' <= b <= '9':
                result = result * 10 + (b - ord('0'))
            else:
                return sign * result
            b = self.read_byte()
            if b == -1 or not ('0' <= b <= '9'):
                break
        raise ValueError("Invalid integer")

    def read_long(self):
        return self.read_int()

def pow(x, y):
    if y < 0:
        return 0
    if y == 0:
        return 1
    if y % 2 == 1:
        return (x * pow(x, y - 1)) % mod
    root = pow(x, y // 2)
    return root * root % mod

def plus(x, y):
    return (x + y) % mod

def sub(x, y):
    return (x - y) % mod

def mul(x, y):
    return (x * y) % mod

def div(x, y):
    return x * pow(y, mod - 2) % mod

def solve():
    pass

if __name__ == "__main__":
    input = FastReader()
    out = sys.stdout
    solve()
    out.flush()