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

def min(x, y):
    return min(x, y)

def max(x, y):
    return max(x, y)

def min3(x, y, z):
    return min(min(x, y), z)

def max3(x, y, z):
    return max(max(x, y), z)

def sort(arr):
    arr.sort()

def rsort(arr):
    arr.sort()
    arr.reverse()

def fill(arr, x):
    for i in range(len(arr)):
        arr[i] = x

def fill2d(arr, x):
    for row in arr:
        for i in range(len(row)):
            row[i] = x

def mod(x, y):
    return (x * y) % mod

def pow_mod(x, y):
    if y < 0:
        return 0
    if y == 0:
        return 1
    if y % 2 == 1:
        return (x * pow_mod(x, y - 1)) % mod
    root = pow_mod(x, y // 2)
    return (root * root) % mod

def div_mod(x, y):
    return (x * pow_mod(y, mod - 2)) % mod

def plus(x, y):
    return (x + y) % mod

def sub(x, y):
    return (x - y) % mod

def mul(x, y):
    return (x * y) % mod

def div(x, y):
    return (x * pow_mod(y, mod - 2)) % mod

def main():
    scanner = FastScanner()
    # Example usage:
    # n = scanner.next_int()
    # arr = scanner.next_int_array(n)
    # print(min3(1, 2, 3))
    # print(max3(1, 2, 3))
    # sort(arr)
    # rsort(arr)
    # fill(arr, 0)
    # print(plus(1, 2))
    # print(sub(5, 2))
    # print(mul(2, 3))
    # print(div(10, 2))
    pass

if __name__ == "__main__":
    main()