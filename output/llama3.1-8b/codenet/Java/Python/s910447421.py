import math
from typing import List

class Main:
    ans = 100
    balls: List[List[int]]
    N: int
    taken: bool

    def main(self):
        self.N = int(input())
        self.ans = self.N
        self.balls = [[int(x) for x in input().split()] for _ in range(self.N)]
        self.balls.sort(key=lambda x: x[0])
        self.solve()
        self.balls = [[y, x] for [x, y] in self.balls]
        self.balls.sort(key=lambda x: x[0])
        self.solve()
        print(self.ans)

    def solve(self):
        for add in range(1, self.N):
            self.taken = [False]*self.N
            p = self.balls[add][0] - self.balls[0][0]
            q = self.balls[add][1] - self.balls[0][1]
            self.ans = min(self.ans, self.check(p, q))

    def check(self, p: int, q: int) -> int:
        ret = 0
        while True:
            added = False
            start = 0
            x = -1
            y = -1
            for i in range(self.N):
                if not self.taken[i]:
                    added = True
                    ret += 1
                    start = i
                    x = self.balls[i][0] + p
                    y = self.balls[i][1] + q
                    break
            if not added:
                break
            for i in range(start+1, self.N):
                if self.balls[i][0] == x and self.balls[i][1] == y:
                    self.taken[i] = True
                    x += p
                    y += q
            return ret

if __name__ == "__main__":
    Main().main()