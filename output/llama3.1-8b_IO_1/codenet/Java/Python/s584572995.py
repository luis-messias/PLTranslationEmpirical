import sys
from collections import defaultdict
import math

mod = int(1e9) + 7

def main():
    N = int(input())
    to = [[] for _ in range(N)]
    edges = []
    for i in range(N-1):
        A, B = map(int, input().split())
        to[A].append(B)
        to[B].append(A)
        edges.append([B, A])

    dp = [0] * N
    rec(0, -1)

    mulsum = 0
    for e in edges:
        candidate1, candidate2 = e[0], e[1]
        child = candidate1 if dp[candidate1] > dp[candidate2] else candidate2

        a, b = dp[child], N - dp[child]

        mul = (math.pow(2, a) - 1) * (math.pow(2, b) - 1) % mod
        mulsum += mul
        mulsum %= mod

    cases = math.pow(2, N)
    PN = (mulsum + (cases - 1 + mod)%mod)%mod 
    BN = N * math.pow(2, N-1) %mod
    WN = (PN - BN + mod)%mod
    ans = WN * pow(cases, mod-2, mod)
    ans %= mod

    print(ans)

def rec(v, parent):
    res = 1
    for next in to[v]:
        if next == parent: continue
        res += rec(next, v)
    return dp[v] = res

def modpow(x, y):
    if y==0: return 1
    if y%2!=0: return x * modpow(x, y-1) % mod
    tmp = modpow(x, y//2)
    return tmp * tmp % mod 

if __name__ == "__main__":
    main()
