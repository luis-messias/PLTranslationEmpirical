import sys
from collections import defaultdict, deque, Counter
from bisect import bisect_left, bisect_right
from itertools import permutations
from math import gcd, ceil
from functools import lru_cache
from heapq import heappush, heappop
from typing import List, Tuple

class Pair:
    def __init__(self, x: int, y: int):
        self.x = x
        self.y = y

    def __hash__(self):
        return (self.x * 1000 + self.y)

    def __eq__(self, other):
        if isinstance(other, Pair):
            return self.x == other.x and self.y == other.y
        return False

    def __lt__(self, other):
        min1 = min(self.x, self.y)
        min2 = min(other.x, other.y)
        if min1 != min2:
            return min1 < min2
        if self.x == other.x:
            return self.y < other.y
        return self.x < other.x

    def __repr__(self):
        return f"Pair({self.x}, {self.y})"

def ceil_div(x: int, y: int) -> int:
    return (x + y - 1) // y

def mod(x: int, m: int) -> int:
    return (x % m + m) % m

def gcd(a: int, b: int) -> int:
    if b == 0:
        return a
    else:
        return gcd(b, a % b)

def pow(a: int, p: int) -> int:
    ans = 1
    while p > 0:
        if (p & 1) == 1:
            ans *= a
        a *= a
        p >>= 1
    return ans

class Scanner:
    def __init__(self):
        self.st = None

    def next(self) -> str:
        while self.st is None or not self.st.hasMoreTokens():
            self.st = sys.stdin.readline().split()
        return self.st.pop(0)

    def nextInt(self) -> int:
        return int(self.next())

    def nextLong(self) -> int:
        return int(self.next())

def main():
    sc = Scanner()
    n = sc.nextInt()
    arr = [sc.nextInt() for _ in range(n)]
    arr.sort(reverse=True)
    if n >= 3:
        ans = arr[0] + arr[1]
        map_ = defaultdict(int)
        map_[Pair(arr[0], arr[1])] += 1
        p1 = Pair(arr[2], arr[1])
        p2 = Pair(arr[2], arr[0])
        map_[p1] += 1
        map_[p2] += 1
        for i in range(3, n):
            p = min(map_.keys(), key=lambda x: max(x.x, x.y))
            ans += min(p.x, p.y)
            del map_[p]
            map_[Pair(p.x, arr[i])] += 1
            map_[Pair(arr[i], p.y)] += 1
        print(ans)
    else:
        print(arr[0])

if __name__ == "__main__":
    main()