import sys
import math

BUFFERSIZE = 512000

class Scanner:
    def __init__(self, file):
        self.file = file
        self.buffer = ''
        self.pos = 0

    def next(self):
        while not self.buffer:
            try:
                chunk = self.file.read(BUFFERSIZE)
            except Exception as e:
                print(e)
                return None
            if not chunk:
                break
            self.buffer += chunk
        space_pos = self.buffer.find(' ', self.pos)
        if space_pos == -1:
            result = self.buffer[self.pos:]
            self.buffer = ''
            self.pos = 0
            return result
        result = self.buffer[self.pos:space_pos]
        self.pos = space_pos + 1
        return result

    def nextInt(self):
        return int(self.next())

    def nextLong(self):
        return int(self.next())

class PrintWriter:
    def __init__(self, file):
        self.file = file

    def println(self, obj):
        print(obj, file=self.file)

def solve():
    position = long_input()
    nrstSeqStartIndx = 1
    while getValueAtIndex(nrstSeqStartIndx * 2) < position:
        nrstSeqStartIndx *= 2
    while getValueAtIndex(nrstSeqStartIndx + 1) <= position:
        nrstSeqStartIndx += 1
    startIndex = getValueAtIndex(nrstSeqStartIndx)
    print((position - startIndex) + 1)

def getValueAtIndex(index):
    return 1 + ((index - 1) * index // 2)

def long_input():
    return int(input())

if __name__ == "__main__":
    input_file = sys.stdin
    solve()