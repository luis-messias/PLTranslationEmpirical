import sys

def ceildiv(x, y):
    return (x + y - 1) // y

def mod(x, m):
    return (int)((x % m + m) % m)

def gcd(a, b):
    while a:
        if not b: 
            break
        a %= b
    return abs(b)

class Main:
    def __init__(self):
        self.pw = sys.stdout
        self.sc = sys.stdin

    class Pair:
        x, y = 0, 0
        
        @staticmethod
        def hash_code():
            return (Pair.x * 1000 + Pair.y)
        
        @staticmethod
        def compare_to(p):
            min1 = min(Pair.x, Pair.y), min2 = min(p.x, p.y)
            if min1 != min2:
                return min1 - min2
            if Pair.x == p.x:
                return P