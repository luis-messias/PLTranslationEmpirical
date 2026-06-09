import sys
from collections import deque
from typing import List, Deque

def disp_que(dt: Deque[int]) -> None:
    """Display ArrayDeque"""
    while len(dt) > 0:
        print(dt.popleft(), end='')
    print()

def disp_list(dt: List) -> None:
    """Display List"""
    for item in dt:
        print(item, end=',')
    print()

def prtlnas(as: List[int]) -> None:
    """Print array elements on separate lines"""
    for item in as:
        print(item)

def prtspas(as: List[int]) -> None:
    """Print array elements on same line with spaces"""
    if len(as) > 0:
        print(as[0], end='')
        for i in range(1, len(as)):
            print(f" {as[i]}", end='')
        print()

def fill(ob: List, res) -> None:
    """Fill list with value"""
    for i in range(len(ob)):
        ob[i] = res

def fill(ob: List[List], res) -> None:
    """Fill 2D list with value"""
    for i in range(len(ob)):
        for j in range(len(ob[0])):
            ob[i][j] = res

def fill(ob: List[List[List]], res) -> None:
    """Fill 3D list with value"""
    for i in range(len(ob)):
        for j in range(len(ob[0])):
            for k in range(len(ob[0][0])):
                ob[i][j][k] = res

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
                self.buflen = self.in_stream.readinto(self.buffer)
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
        return 33 <= c <= 126
    
    def hasNext(self) -> bool:
        while self.hasNextByte() and not self.isPrintableChar(self.buffer[self.ptr]):
            self.ptr += 1
        return self.hasNextByte()
    
    def next(self) -> str:
        if not self.hasNext():
            raise Exception("No more tokens")
        sb = []
        b = self.readByte()
        while self.isPrintableChar(b):
            sb.append(chr(b))
            b = self.readByte()
        return ''.join(sb)
    
    def nextL(self) -> int:
        if not self.hasNext():
            raise