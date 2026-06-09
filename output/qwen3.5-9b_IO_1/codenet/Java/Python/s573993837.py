import sys

class InputReader:
    def __init__(self):
        self.input = sys.stdin.read().split()
        self.pos = 0
    
    def next(self):
        if self.pos >= len(self.input):
            return None
        token = self.input[self.pos]
        self.pos += 1
        return token
    
    def nextInt(self):
        return int(self.next())
    
    def nextLong(self):
        return int(self.next())

def solve():
    reader = InputReader()
    while True:
        token = reader.next()
        if token is None:
            break
        n = int(token)
        m = int(reader.next())
        
        if n == 0:
            print(0)
            continue
        if n == m:
            print(0)
            continue
        if n > m:
            n = m + n % m
            n -= m
            print(min(m - n, n))
            continue
        print(min(m - n, n))

if __name__ == "__main__":
    solve()
