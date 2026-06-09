import sys
from typing import List

class MyRunnable:
    def run(self):
        n, k = map(int, input().split())
        as_ = []
        for _ in range(n):
            as_.append(int(input()) - 1)
        print(Calculator(n, k, as_).calculate())

class Calculator:
    def __init__(self, n: int, k: int, as_: List[int]):
        self.k = k
        self.answer = 0
        self.lists = [[] for _ in range(n)]
        for i in range(n):
            if i > 0:
                self.lists[as_[i]].append(i)
            elif as_[i] > 0:
                self.answer += 1

    def calculate(self) -> int:
        if not hasattr(self, 'result'):
            self.dfs(0, 0)
        return self.answer

    def dfs(self, a: int, pre: int) -> int:
        h = 0
        for i in self.lists[a]:
            h = max(h, self.dfs(i, a))
        if pre > 0 and h == self.k - 1:
            h = 0
            self.answer += 1
        else:
            h += 1
        return h

if __name__ == "__main__":
    MyRunnable().run()