import sys

class Helper:
    def __init__(self):
        self.buf_size = 1 << 20
        self.buf = [0] * self.buf_size
        self.index = 0
        self.total = 0
        self.in = None
    
    def initIO(self, is):
        self.in = is
    
    def scan(self):
        if self.index >= self.total:
            self.index = 0
            self.total = self.in.read(self.buf_size)
            if self.total <= 0:
                return -1
        return self.buf[self.index]
    
    def next(self):
        c = self.scan()
        while c <= 32:
            c = self.scan()
        sb = []
        while c > 32:
            sb.append(chr(c))
            c = self.scan()
        return ''.join(sb)
    
    def nextInt(self):
        c = self.scan()
        while c <= 32:
            c = self.scan()
        neg = c == '-'
        if c == '-' or c == '+':
            c = self.scan()
        val = 0
        while c >= '0' and c <= '9':
            val = (val << 3) + (val << 1) + (ord(c) & 15)
            c = self.scan()
        return -val if neg else val
    
    def nextLong(self):
        c = self.scan()
        while c <= 32:
            c = self.scan()
        neg = c == '-'
        if c == '-' or c == '+':
            c = self.scan()
        val = 0
        while c >= '0' and c <= '9':
            val = (val << 3) + (val << 1) + (ord(c) & 15)
            c = self.scan()
        return -val if neg else val
    
    def print(self, a):
        sys.stdout.write(str(a))
    
    def printsp
