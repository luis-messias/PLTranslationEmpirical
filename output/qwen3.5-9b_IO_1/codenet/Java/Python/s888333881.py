from typing import List, Deque
import sys

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
            raise Exception("No more tokens")
        n = 0
        minus = False
        b = self.readByte()
        if b == ord('-'):
            minus = True
            b = self.readByte()
        if b < ord('0') or ord('9') < b:
            raise Exception("Invalid number")
        while True:
            if ord('0') <= b <= ord('9'):
                n *= 10
                n += b - ord('0')
            elif b == -1 or not self.isPrintableChar(b) or b == ord(':'):
                return -n if minus else n
            else:
                raise Exception("Invalid number")
            b = self.readByte()
    
    def nextI(self) -> int:
        nl = self.nextL()
        if nl < -2147483648 or nl > 2147483647:
            raise Exception("Number out of int range")
        return int(nl)
    
    def nextD(self) -> float:
        return float(self.next())
    
    def ni(self, array: List[int]) -> None:
        for i in range(len(array)):
            array[i] = self.nextI()
    
    def ni(self, array: List[int], array2: List[int]) -> None:
        for i in range(len(array)):
            array[i] = self.nextI()
            array2[i] = self.nextI()
    
    def ni(self, array: List[int], array2: List[int], array3: List[int]) -> None:
        for i in range(len(array)):
            array[i] = self.nextI()
            array2[i] = self.nextI()
            array
