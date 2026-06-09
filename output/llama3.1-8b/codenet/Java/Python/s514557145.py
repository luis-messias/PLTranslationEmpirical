import sys
from functools import reduce

MOD1=1000000007
MOD2=998244353
inv9=modInv(9)

class S:
    E = S(0, float('inf'), -float('inf'))
    def __init__(self, sum, l, r):
        self.sum = sum
        self.l=l
        self.r=r

    @staticmethod
    def op(s1, s2):
        sum=s1.sum+s2.sum
        if sum>=MOD2:
            sum-=MOD2
        return S(sum, min(s1.l, s2.l), max(s1.r, s2.r))

    @staticmethod
    def map(f,  s):
        c=(10**(f.N-s.r-1)-10**(f.N-s.l))%MOD2
        if c<0:
            c+=MOD2
        return S(((c*f.D)%MOD2*inv9)%MOD2, s.l,s.r)

class F:
    I = F(0, 0)
    def __init__(self, D, N):
        self.D = D
        self.N= N

    @staticmethod
    def composite(f, g):
        return F(f.D,f.N)

def modInv(x):
    return pow(x, MOD2 - 2, MOD2)

def modPow(x, y):
    z = 1
    while y > 0:
        if y % 2 == 0:
            x = (x * x) % MOD2
            y //= 2
        else:
            z = (z * x) % MOD2
            y-=1
    return z

class LazySegTree:
    def __init__(self, n, op, e, mapping, composition, id):
        self.MAX = n
        k = 1
        while k < n:
            k <<= 1
        self.N = k
        self.Log = (self.N - 1).bit_length()
        self.Op = op
        self.E = e
        self.Mapping = mapping
        self.Composition = composition
        self.Id = id
        self.Dat = [e] * (2 * self.N)
        self.Laz = [id] * self.N

    def build(self, dat):
        for i in range(len(dat)):
            self.Dat[self.N + i] = dat[i]
        for i in range(self.N - 1, 0, -1):
            self.Dat[i] = self.Op(self.Dat[2 * i], self.Dat[2 * i + 1])

    def apply(self, k, f):
        if self.Laz[k] == self.Id:
            return
        self.Dat[k] = self.Mapping(f, self.Dat[k])
        self.Laz[k] = self.Composition(f, self.Laz[k])

    def push(self, k):
        self.apply(2 * k, self.Laz[k])
        self.apply(2 * k + 1, self.Laz[k])
        self.Laz[k] = self.Id

    def update(self, k, new_val):
        k += self.N
        self.Dat[k] = new_val
        while k > 1:
            k >>= 1
            self.push(k)

    def query(self, l, r):
        l += self.N
        r += self.N + 1
        res_left = self.E
        res_right = self.E
        while l < r:
            if l % 2 == 1:
                res_left = self.Op(res_left, self.Dat[l])
                l += 1
            if r % 2 == 1:
                r -= 1
                res_right = self.Op(self.Dat[r], res_right)
            l >>= 1
            r >>= 1
        return self.Op(res_left, res_right)

    def maxRight(self, l, g):
        l += self.N
        if not g(self.E):
            raise ValueError("Identity element must satisfy the condition.")
        if l == self.MAX:
            return self.MAX
        while l % 2 == 0:
            l >>= 1
        res = None
        while True:
            self.push(l)
            if g(self.Dat[l]):
                res = l - self.N
                l = 2 * l + 1
            else:
                while l < self.N:
                    push(l)
                    l = 2 * l
                return res

    def minLeft(self, r, g):
        r += self.N
        if not g(self.E):
            raise ValueError("Identity element must satisfy the condition.")
        if r == 0:
            return 0
        while (r - 1) % 2 == 0:
            r -= 1
            r >>= 1
        res = None
        while True:
            self.push(r - 1)
            if g(self.Dat[r]):
                res = r + self.N
                r = 2 * r - 1
            else:
                while r < self.N:
                    push(r - 1)
                    r = 2 * r - 1
                return res

class InputReader:
    def __init__(self, in_stream):
        self.in_stream = in_stream
        self.buffer = []
        self.curbuf = 0
        self.lenbuf = 0

    def hasNextByte(self):
        if self.curbuf >= self.lenbuf:
            self.curbuf = 0
            try:
                self.lenbuf = self.in_stream.read(self.buffer)
            except Exception as e:
                raise InputMismatchException()
            if self.lenbuf <= 0:
                return False
        return True

    def readByte(self):
        if self.hasNextByte():
            return self.buffer[self.curbuf]
        else:
            return -1

    def isSpaceChar(self, c):
        return not (c >= 33 and c <= 126)

    def skip(self):
        while self.hasNextByte() and self.isSpaceChar(self.buffer[self.curbuf]):
            self.curbuf += 1

    def hasNext(self):
        self.skip()
        return self.hasNextByte()

    def next(self):
        if not self.hasNext():
            raise NoSuchElementException()
        res = ''
        b = self.readByte()
        while not self.isSpaceChar(b):
            res += chr(b)
            b = self.readByte()
        return res

    def nextInt(self):
        if not self.hasNext():
            raise NoSuchElementException()
        c = self.readByte()
        while self.isSpaceChar(c):
            c = self.readByte()
        minus = False
        if c == '-':
            minus = True
            c = self.readByte()
        res = 0
        while not self.isSpaceChar(c):
            if c < '0' or c > '9':
                raise InputMismatchException()
            res = res * 10 + c - '0'
            c = self.readByte()
        return -res if minus else res

    def nextLong(self):
        if not self.hasNext():
            raise NoSuchElementException()
        c = self.readByte()
        while self.isSpaceChar(c):
            c = self.readByte()
        minus = False
        if c == '-':
            minus = True
            c = self.readByte()
        res = 0
        while not self.isSpaceChar(c):
            if c < '0' or c > '9':
                raise InputMismatchException()
            res = res * 10 + c - '0'
            c = self.readByte()
        return -res if minus else res

    def nextDouble(self):
        return float(self.next())

def main():
    in_stream = sys.stdin
    n = int(in_stream.readline())
    tree = LazySegTree(n, S.op, S.E, S.map, F.composite, F.I)
    for i in range(n):
        a = int(in_stream.readline())
        tree.update(i, S(a, 0, 0))
    q = int(in_stream.readline())
    for _ in range(q):
        t = in_stream.readline().split()
        if t[0] == 'update':
            i = int(t[1]) - 1
            a = int(t[2])
            tree.update(i, S(a, 0, 0))
        elif t[0] == 'query':
            l = int(t[1]) - 1
            r = int(t[2])
            print(tree.query(l, r).sum)
        elif t[0] == 'max_right':
            l = int(t[1]) - 1
            g = lambda x: x.sum >= int(t[2])
            print(tree.maxRight(l, g) + n)

if __name__ == '__main__':
    main()