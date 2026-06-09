import sys
from typing import List, Tuple

def main():
    n = int(input())
    a = [[0] * n for _ in range(2)]
    for i in range(n):
        a[0][i] = int(input())
        a[1][i] = int(input())

    memo = [[[float('inf')] * (1 << n) for _ in range(n + 1)] for _ in range(2)]

    def dp(fliped: int, idx: int, msk: int) -> int:
        if msk == (1 << n) - 1:
            return 0
        if memo[fliped][idx][msk] != float('inf'):
            return memo[fliped][idx][msk]
        x = bin(msk).count('1')
        ff = 0
        ans = float('inf')
        for i in range(n):
            if (msk & (1 << i)) == 0:
                nf = x % 2
                if idx == n or a[fliped][idx] <= a[(nf + (ff % 2)) % 2][i]:
                    ans = min(ans, ff + dp((nf + (ff % 2)) % 2, i, msk | 1 << i))
                ff += 1
            else:
                x -= 1
        return memo[fliped][idx][msk] = ans

    ans = dp(0, n, 0)
    print(-1 if ans >= float('inf') else ans)

if __name__ == "__main__":
    main()