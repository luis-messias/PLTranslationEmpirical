import sys
from collections import defaultdict

MOD = 1000000007
MAX = int(2**63 - 1)
N = int(1e6) + 1

class atcoder_ABC167_D:
    def __init__(self):
        self.sc = input()
        self.used = set()

    def doIt(self):
        N, K = map(int, self.sc.split())
        A = list(map(lambda x: int(x) - 1, self.sc.split()))[:N]
        idx = [-1] * N
        pos = [-1] * N

        cur = 0
        next = A[0]

        while True:
            if next == -1:
                break
            if next not in self.used:
                self.used.add(next)
                idx[next] = cur
                pos[cur] = next
                cur += 1
                next = A[next]
            else:
                a = cur - idx[next]
                b = idx[next]
                ans = (10000 * a + K - b) % a + b
                if b > K:
                    ans = K
                print(pos[ans] + 1)
                break

atcoder_ABC167_D().doIt()