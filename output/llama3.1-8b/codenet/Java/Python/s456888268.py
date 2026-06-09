import sys
from typing import List, Tuple

class InputMismatchException(Exception):
    pass

def readByte():
    global ptrbuf, lenbuf, is
    if lenbuf == -1:
        raise InputMismatchException()
    if ptrbuf >= lenbuf:
        try:
            lenbuf = is.read(inbuf)
        except Exception as e:
            print(e)
            raise InputMismatchException()
        if lenbuf <= 0:
            return -1
    return inbuf[ptrbuf]

def skip():
    global ptrbuf, lenbuf, is
    while True:
        b = readByte()
        if b == -1 or not (b >= 33 and b <= 126):
            break
    return b

def ns():
    global ptrbuf, lenbuf, is
    b = skip()
    sb = []
    while True:
        if b != -1 and not (b >= 33 and b <= 126):
            break
        sb.append(chr(b))
        b = readByte()
    return ''.join(sb)

def nm(n: int, m: int) -> List[List[str]]:
    map = [ns(m) for _ in range(n)]
    return map

def na(n: int) -> List[int]:
    a = []
    for i in range(n):
        a.append(int(ns()))
    return a

def nla(n: int) -> List[int]:
    a = []
    for i in range(n):
        a.append(int(ns()))
    return a

def ni() -> int:
    num = 0
    b = readByte()
    minus = False
    while True:
        if b >= '0' and b <= '9':
            num = num * 10 + (b - '0')
        else:
            return minus and -num or num
        b = readByte()

def nl() -> int:
    num = 0
    b = readByte()
    minus = False
    while True:
        if b >= '0' and b <= '9':
            num = num * 10 + (b - '0')
        else:
            return minus and -num or num
        b = readByte()

def isSpaceChar(c: int) -> bool:
    return not (c >= 33 and c <= 126)

def pow(x, y):
    if y < 0:
        return 0
    if y == 0:
        return 1
    if y % 2 == 1:
        return (x * pow(x, y - 1)) % mod
    root = pow(x, y // 2)
    return root * root % mod

def div(x, y):
    return x * pow(y, mod - 2) % mod

def mul(x, y):
    return (x * y) % mod

def plus(x, y):
    return (x + y) % mod

def sub(x, y):
    return (x - y) % mod

mod = 1000000007
is = sys.stdin.buffer

# Example usage:
print(na(5))  # prints [1, 2, 3, 4, 5]
print(pow(10, 20))