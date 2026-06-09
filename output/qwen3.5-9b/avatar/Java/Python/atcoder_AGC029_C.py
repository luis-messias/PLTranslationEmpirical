import sys
from collections import Counter

class atcoder_AGC029_C:
    def __init__(self):
        self.n = 0
        self.a = []
        self.s = {}
    
    def solve(self):
        self.set()
        ng = 0
        ok = self.n
        while ok - ng > 1:
            k = (ng + ok) // 2
            if self.isPossible(k):
                ok = k
            else:
                ng = k
        print(ok)
    
    def set(self):
        try:
            n = int(input())
            a = list(map(int, input().split()))
            self.n = n
            self.a = a
            self.s = {}
        except:
            pass
    
    def isPossible(self, k):
        self.s = {}
        current = 0
        for ai in self.a:
            if ai <= current:
                if k == 1:
                    return False
                while self.s and max(self.s.keys()) >= ai:
                    self.s.pop(max(self.s.keys()))
                p = ai - 1
                while True:
                    if p < 0:
                        return False
                    sp = self.s.get(p, 0) + 1
                    self.s[p] = sp
                    if sp == k:
                        self.s.pop(p)
                        p -= 1
                    else:
                        break
            current = ai
        return True

if __name__ == "__main__":
    m = atcoder_AGC029_C()
    m.solve()