import sys
from typing import List, Tuple

class UnionFind:
    def __init__(self, n: int):
        self.Parent = [-1] * n

    def root(self, A: int) -> int:
        if self.Parent[A] < 0:
            return A
        self.Parent[A] = self.root(self.Parent[A])
        return self.Parent[A]

    def size(self, A: int) -> int:
        return -self.Parent[self.root(A)]

    def connect(self, A: int, B: int) -> bool:
        A = self.root(A)
        B = self.root(B)
        if A == B:
            return False
        if self.size(A) < self.size(B):
            A, B = B, A
        self.Parent[A] += self.Parent[B]
        self.Parent[B] = A
        return True

class Main:
    def __init__(self):
        self.mod = 10**9 + 7
        self.eps = 1e-14
        self.big = sys.maxsize
        self.PI = 3.14159265358979323846262338327950288

    def modlcm(self, a: int, b: int) -> int:
        return (a * b // self.gcd(a, b)) % self.mod

    def gcd(self, a: int, b: int) -> int:
        if b == 0:
            return a
        else:
            return self.gcd(b, a % b)

    def lcm(self, a: int, b: int) -> int:
        return (a * b // self.gcd(a, b))

    def max(self, a: int, b: int) -> int:
        return max(a, b)

    def min(self, a: int, b: int) -> int:
        return min(a, b)

    def lmax(self, a: int, b: int) -> int:
        return max(a, b)

    def lmin(self, a: int, b: int) -> int:
        return min(a, b)

    def factorial(self, i: int) -> int:
        if i == 1:
            return 1
        else:
            return i * self.factorial(i - 1)

    def lower_bound(self, a: List[int], key: int) -> int:
        left = 0
        right = len(a)
        while right - left > 1:
            mid = (right + left) // 2
            if a[mid] < key:
                left = mid
            else:
                right = mid
        return left

    def upper_bound(self, a: List[int], key: int) -> int:
        left = 0
        right = len(a)
        while right - left > 1:
            mid = (right + left) // 2
            if a[mid] <= key:
                left = mid
            else:
                right = mid
        return left

    def isPrime(self, n: int) -> bool:
        if n == 2:
            return True
        if n < 2 or n % 2 == 0:
            return False
        for i in range(3, int(n ** 0.5) + 1, 2):
            if n % i == 0:
                return False
        return True

    def upper_division(self, a: int, b: int) -> int:
        if a % b == 0:
            return a // b
        else:
            return a // b + 1

    def lupper_division(self, a: int, b: int) -> int:
        if a % b == 0:
            return a // b
        else:
            return a // b + 1

    def setArray(self, a: int) -> List[int]:
        b = [self.scan.nextInt() for _ in range(a)]
        return b

    def lsetArray(self, a: int) -> List[int]:
        b = [self.scan.nextLong() for _ in range(a)]
        return b

    def reverse(self, str: str) -> str:
        ch = list(str)
        a = len(str)
        for i in range(self.upper_division(a, 2)):
            ch[i] = ch[a - i - 1]
            ch[a - i - 1] = ch[i]
        return ''.join(ch)

    def printArray(self, que: List[int]) -> None:
        for i in range(len(que) - 1):
            print(que[i], end=' ')
        print(que[-1])

    def doublesort(self, a: List[Tuple[int]]) -> List[Tuple[int]]:
        a.sort(key=lambda x: x[0])
        return a

    def ldoublesort(self, a: List[Tuple[int]]) -> List[Tuple[int]]:
        a.sort(key=lambda x: x[0])
        return a

    def modpow(self, x: int, n: int, mo: int) -> int:
        sum = 1
        while n > 0:
            if (n & 1) == 1:
                sum = (sum * x) % mo
            x = (x * x) % mo
            n >>= 1
        return sum

    def revch(self, ch: str) -> str:
        ret = list(ch)
        for i in range(len(ch)):
            ret[i] = ch[-i - 1]
        return ''.join(ret)

    def revint(self, ch: List[int]) -> List[int]:
        ret = [0] * len(ch)
        for i in range(len(ch)):
            ret[i] = ch[-i - 1]
        return ret

    def warshall_floyd(self, v: List[List[int]], n: int) -> None:
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    v[i][j] = min(v[i][j], v[i][k] + v[k][j])

    def modint(self, a: int, m: int) -> int:
        b = m
        u = 1
        v = 0
        while b != 0:
            t = a // b
            a -= t * b
            x = a
            a = b
            b = x

            u -= t * v
            x = u
            u = v
            v = x
        u %= m
        if u < 0:
            u += m
        return u

class FastScanner:
    def __init__(self):
        self.in_ = sys.stdin
        self.buffer = [0] * 1024
        self.ptr = 0
        self.buflen = 0

    def hasNextByte(self) -> bool:
        if self.ptr < self.buflen:
            return True
        else:
            self.ptr = 0
            try:
                self.buflen = self.in_.read(self.buffer)
            except Exception as e:
                print(e)
            if self.buflen <= 0:
                return False
        return True

    def readByte(self) -> int:
        if self.hasNextByte():
            return self.buffer[self.ptr]
        else:
            return -1

    def isPrintableChar(self, c: int) -> bool:
        return 33 <= c and c <= 126

    def hasNext(self) -> bool:
        while self.hasNextByte() and not self.isPrintableChar(self.buffer[self.ptr]):
            self.ptr += 1
        return self.hasNextByte()

    def next(self) -> str:
        if not self.hasNext():
            raise Exception('No more input')
        sb = ''
        b = self.readByte()
        while self.isPrintableChar(b):
            sb += chr(b)
            b = self.readByte()
        return sb

    def nextLong(self) -> int:
        if not self.hasNext():
            raise Exception('No more input')
        n = 0
        minus = False
        b = self.readByte()
        if b == '-':
            minus = True
            b = self.readByte()
        if b < '0' or '9' < b:
            raise Exception('Invalid number format')
        while True:
            if '0' <= b and b <= '9':
                n *= 10
                n += b - '0'
            elif b == -1 or not self.isPrintableChar(b):
                return n if not minus else -n
            else:
                raise Exception('Invalid number format')
            b = self.readByte()

    def nextInt(self) -> int:
        nl = self.nextLong()
        if nl < sys.minsize or nl > sys.maxsize:
            raise Exception('Number out of range')
        return int(nl)

    def nextDouble(self) -> float:
        return float(self.next())

    def nextchar(self) -> str:
        try:
            return chr(sys.stdin.read(1))
        except Exception as e:
            print(e)
            raise RuntimeError(e)

if __name__ == '__main__':
    main = Main()
    scan = FastScanner()

    s = input()
    if s == main.reverse(s):
        print('Yes')
    else:
        print('No')
