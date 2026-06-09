import sys
from typing import List, Callable

class SegmentTree:
    def __init__(self, n: int, identity: int, op: Callable[[int, int], int], mapping: Callable[[int], int]):
        self.N = n
        self.MAX = 2 * n
        self.E = identity
        self.Op = op
        self.Mapping = mapping
        self.Dat = [identity] * (2 * n)
        self.Laz = [identity] * (2 * n)
        self.build()
    
    def build(self):
        for i in range(self.N):
            self.Dat[i + self.N] = self.Mapping(i)
        for i in range(self.N - 1, -1, -1):
            self.Dat[i] = self.Op(self.Dat[i << 1], self.Dat[i << 1 | 1])
    
    def push(self, p: int):
        if self.Laz[p] != self.E:
            self.Dat[p << 1] = self.Mapping(self.Laz[p])
            self.Dat[p << 1 | 1] = self.Mapping(self.Laz[p])
            self.Laz[p << 1] = self.Op(self.Laz[p << 1], self.Laz[p])
            self.Laz[p << 1 | 1] = self.Op(self.Laz[p << 1 | 1], self.Laz[p])
            self.Laz[p] = self.E
    
    def pushTo(self, p: int):
        while p > 1:
            p >>= 1
            self.push(p)
    
    def update(self, l: int, r: int, val: int):
        self.updateFrom(l, r, val)
    
    def updateFrom(self, l: int, r: int, val: int):
        l += self.N
        r += self.N
        while l <= r:
            if (l & 1) == 1:
                self.Dat[l] = self.Mapping(val)
                self.Laz[l] = self.Op(self.Laz[l], val)
                l += 1
            if (r & 1) == 0:
                self.Dat[r] = self.Mapping(val)
                self.Laz[r] = self.Op(self.Laz[r], val)
                r -= 1
            l >>= 1
            r >>= 1
        while l > 1:
            l >>= 1
            self.push(l)
        while r > 1:
            r >>= 1
            self.push(r)
    
    def query(self, l: int, r: int) -> int:
        l += self.N
        r += self.N
        left_res = self.E
        right_res = self.E
        while l <= r:
            if (l & 1) == 1:
                left_res = self.Op(left_res, self.Dat[l])
                l += 1
            if (r & 1) == 0:
                right_res = self.Op(self.Dat[r], right_res)
                r -= 1
            l >>= 1
            r >>= 1
        return self.Op(left_res, right_res)
    
    def maxRight(self, l: int, g: Callable[[int], bool]) -> int:
        if not g(self.E):
            raise ValueError("Identity element must satisfy the condition.")
        if l >= self.MAX:
            return self.MAX
        l += self.N
        self.pushTo(l)
        sum_val = self.E
        while True:
            if (l & -l) != l:
                l >>= 1
                if not g(self.Op(sum_val, self.Dat[l])):
                    while l < self.N:
                        self.push(l)
                        l = l << 1
                        if g(self.Op(sum_val, self.Dat[l])):
                            sum_val = self.Op(sum_val, self.Dat[l])
                            l += 1
                    return l - self.N
                sum_val = self.Op(sum_val, self.Dat[l])
                l += 1
            else:
                return l - self.N
    
    def minLeft(self, r: int, g: Callable[[int], bool]) -> int:
        if not g(self.E):
            raise ValueError("Identity element must satisfy the condition.")
        if r == 0:
            return 0
        r += self.N
        self.pushTo(r - 1)
        sum_val = self.E
        while True:
            r -= 1
            while r > 1 and (r & 1) == 1:
                r >>= 1
            if not g(self.Op(self.Dat[r], sum_val)):
                while r < self.N:
                    self.push(r)
                    r = r << 1 | 1
                    if g(self.Op(self.Dat[r], sum_val)):
                        sum_val = self.Op(self.Dat[r], sum_val)
                        r -= 1
                return r + 1 - self.N
            sum_val = self.Op(self.Dat[r], sum_val)
            if (r & -r) != r:
                r >>= 1
            else:
                return 0

def solve():
    input_data = sys.stdin.read().split()
    idx = 0
    n = int(input_data[idx])
    idx += 1
    m = int(input_data[idx])
    idx += 1
    
    # Read initial array
    a = [int(input_data[idx + i]) for i in range(n)]
    idx += n
    
    # Build segment tree with values
    def identity():
        return 0
    
    def op(x, y):
        return x + y
    
    def mapping(x):
        return x
    
    st = SegmentTree(n, 0, op, mapping)
    for i in range(n):
        st.Dat[i + st.N] = a[i]
    for i in range(n - 1, -1, -1):
        st.Dat[i] = op(st.Dat[i << 1], st.Dat[i << 1 | 1])
    
    # Process queries
    for _ in range(m):
        l = int(input_data[idx])
        idx += 1
        r = int(input_data[idx])
        idx += 1
        k = int(input_data[idx])
        idx += 1
        
        # For each position, find the k-th smallest value in range [l, r]
        # This is a selection problem
        result = []
        for i in range(n):
            #
