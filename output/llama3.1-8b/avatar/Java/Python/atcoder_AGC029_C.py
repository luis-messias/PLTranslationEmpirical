import sys
from collections import defaultdict

class atcoder_AGC029_C:
    def __init__(self):
        self.n = 0
        self.a = []
        self.s = defaultdict(int)

    def main(self):
        self.solve()

    def set(self):
        try:
            self.n = int(input())
            self.a = list(map(int, input().split()))
            self.s.clear()
        except Exception as e:
            print(e)

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

    def isPossible(self, k):
        self.s.clear()
        current = 0
        for ai in self.a:
            if ai <= current:
                if k == 1:
                    return False
                while self.s and list(self.s.keys())[-1] >= ai:
                    self.s.pop(list(self.s.keys())[-1])
                p = ai - 1
                while True:
                    if p < 0:
                        return False
                    sp = self.s.get(p, 0) + 1
                    self.s[p] = sp
                    if sp == k:
                        del self.s[p]
                        p -= 1
                    else:
                        break
            current = ai
        return True

if __name__ == "__main__":
    m = atcoder_AGC029_C()
    m.main()