import sys
import time
from random import randint

class Solver:
    def __init__(self):
        self.hp = Helper(10**9 + 7, 1000_006)
        self.timer = None
        self.task = None

    def solve(self):
        if TESTCASES:
            tc = self.hp.nextInt()
        else:
            tc = 1
        for tce in range(1, tc+1):
            self.solve(tce)

        self.timer.cancel()
        self.hp.flush()

class Helper:
    def __init__(self, mod, maxn):
        self.MOD = mod
        self.MAXN = maxn
        self.rnd = randint(0, 2**32-1)

    def sieve(self):
        primes = []
        sieve = [0] * self.MAXN
        for i in range(2, self.MAXN):
            if sieve[i] == 0:
                primes.append(i)
                for j in range(i, self.MAXN, i):
                    sieve[j] = i
        return primes

    def factorial(self):
        factorial = [1] * self.MAXN
        for i in range(1, self.MAXN):
            factorial[i] = (factorial[i-1] * i) % self.MOD
        return factorial

    def ncr(self, n, r):
        if r > n:
            return 0
        numerator = self.factorial(n)
        denominator = (self.factorial(r) * self.factorial(n-r)) % self.MOD
        return (numerator * pow(denominator, self.MOD-2, self.MOD)) % self.MOD

    def getLongArray(self, size):
        ar = [0] * size
        for i in range(size):
            ar[i] = self.nextInt()
        return ar

    def getIntArray(self, size):
        ar = [0] * size
        for i in range(size):
            ar[i] = self.nextInt()
        return ar

    def nextInt(self):
        c = sys.stdin.read(1)
        while c <= ' ':
            c = sys.stdin.read(1)
        neg = False
        if c == '-':
            neg = True
            c = sys.stdin.read(1)
        val = 0
        for c in sys.stdin.read(1):
            if c >= '0' and c <= '9':
                val = (val << 3) + (val << 1) + (c & 15)
        return -val if neg else val

    def nextLong(self):
        c = sys.stdin.read(1)
        while c <= ' ':
            c = sys.stdin.read(1)
        neg = False
        if c == '-':
            neg = True
            c = sys.stdin.read(1)
        val = 0
        for c in sys.stdin.read(1):
            if c >= '0' and c <= '9':
                val = (val << 3) + (val << 1) + (c & 15)
        return -val if neg else val

    def gcd(self, a, b):
        return b if b == 0 else self.gcd(b, a % b)

    def max(self, *ar):
        ret = ar[0]
        for itr in ar:
            ret = max(ret, itr)
        return ret

    def min(self, *ar):
        ret = ar[0]
        for itr in ar:
            ret = min(ret, itr)
        return ret

    def sum(self, *ar):
        sum = 0
        for itr in ar:
            sum += itr
        return sum

def main():
    solver = Solver()
    try:
        solver.solve()
        sys.exit(0)
    except Exception as e:
        print(e)
        sys.exit(1)

if __name__ == "__main__":
    main()