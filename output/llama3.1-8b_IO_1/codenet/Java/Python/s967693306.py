import sys
from math import gcd, ceil
from functools import reduce
from collections import defaultdict
from itertools import permutations

MOD = 10**9 + 7
INF = float('inf')

class FastScanner:
    def __init__(self):
        self.stdin = sys.stdin

    def next(self):
        return self.stdin.readline().strip()

    def next_ints(self):
        return list(map(int, self.next().split()))

    def next_long(self):
        return int(self.next())

    def next_doubles(self):
        return [float(x) for x in self.next().split()]

class Main:
    def __init__(self):
        self.sc = FastScanner()
        self.modfact = [1] * (10**6 + 5)
        for i in range(2, len(self.modfact)):
            self.modfact[i] = (self.modfact[i-1] * i) % MOD

    def solve(self):
        n, m = self.sc.next_ints()
        map_ = defaultdict(int)

        for _ in range(m):
            s, c = self.sc.next_ints()
            if map_[s] != 0 and map_[s] != c:
                print(-1)
                return

            map_[s] = c

        ans = []
        for i in range(n):
            if map_[i+1] == 0:
                ans.append(1)
            elif map_[i+1] != 0:
                ans.append(map_[i+1])

        s = ''.join(str(x) for x in ans)

        if len(s) != n or (int(s) == 0 and n != 1):
            print(-1)
            return

        for i in range(10**3):
            s = str(i).zfill(n)
            flag = True
            for j in range(n):
                if map_[j+1] != 0 and map_[j+1] != int(s[j]) or (map_[j+1] == 0 and int(s[j]) != 0):
                    if map_[j+1] == 0 and j == 0 and int(s[j]) == 1:
                        continue
                    flag = False
                    break

            if flag and len(s) == n:
                print(s)
                return

        print(-1)

if __name__ == '__main__':
    main = Main()
    main.solve()
