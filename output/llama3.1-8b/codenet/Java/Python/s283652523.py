import sys
from typing import List

class FastScanner:
    def __init__(self, stream):
        self.input = stream

    def close(self):
        pass

    def nextInt(self) -> int:
        return int(next(self))

    def nextLong(self) -> int:
        return int(next(self))

    def nextDouble(self) -> float:
        return float(next(self))

    def nextChar(self) -> str:
        return next(self)

    def nextStr(self) -> str:
        return next(self).strip()

    def nextLine(self) -> str:
        return next(self).strip()

    def nextIntArray(self, n: int) -> List[int]:
        return [self.nextInt() for _ in range(n)]

    def nextLongArray(self, n: int) -> List[int]:
        return [self.nextLong() for _ in range(n)]

def solve():
    N = fs.nextInt()
    A = fs.nextIntArray(N)
    
    ans = 0
    sum = A[-1]
    for i in range(N - 2, -1, -1):
        ans += (sum * A[i]) % MOD
        ans %= MOD
        sum += A[i]
        sum %= MOD
    print(ans)

MOD = int(1e9 + 7)
fs = FastScanner(sys.stdin)
solve()