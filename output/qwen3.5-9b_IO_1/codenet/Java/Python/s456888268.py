import sys
from typing import List

class FastScanner:
    def __init__(self):
        self.input = sys.stdin.read().split()
        self.pos = 0
    
    def next(self):
        if self.pos >= len(self.input):
            return None
        token = self.input[self.pos]
        self.pos += 1
        return token
    
    def next_int(self):
        return int(self.next())
    
    def next_long(self):
        return int(self.next())
    
    def next_double(self):
        return float(self.next())
    
    def next_char(self):
        return self.next()[0]
    
    def next_string(self):
        return self.next()
    
    def next_int_array(self, n):
        return [int(self.next()) for _ in range(n)]
    
    def next_long_array(self, n):
        return [int(self.next()) for _ in range(n)]
    
    def next_double_array(self, n):
        return [float(self.next()) for _ in range(n)]
    
    def next_char_array(self, n):
        return [self.next()[0] for _ in range(n)]
    
    def next_string_array(self, n):
        return [self.next() for _ in range(n)]

def main():
    scanner = FastScanner()
    s = scanner.next_string()
    
    if not s:
        return
    
    seen_pairs = set()
    for i in range(len(s) - 1):
        pair = (s[i], s[i + 1])
        seen_pairs.add(pair)
    
    print(len(seen_pairs))

if __name__ == "__main__":
    main()
