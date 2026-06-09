import sys

class Codeforces_203_A:
    def __init__(self):
        self.x = int(input())
        self.t = int(input())
        self.a = int(input())
        self.b = int(input())
        self.da = int(input())
        self.db = int(input())

    def solve(self):
        ok = False
        for i in range(self.t):
            first = self.a - (self.da * i)
            for j in range(self.t):
                second = self.b - (self.db * j)
                if second + first == self.x or second == self.x or first == self.x or self.x == 0:
                    ok = True
                    break
        print("YES" if ok else "NO")

if __name__ == "__main__":
    cf_203_a = Codeforces_203_A()
    cf_203_a.solve()