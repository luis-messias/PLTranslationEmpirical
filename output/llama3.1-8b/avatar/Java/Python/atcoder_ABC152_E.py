import math
from functools import reduce
from typing import List

def gcd(a: int, b: int) -> int:
    while b != 0:
        a, b = b, a % b
    return a

def lcm(a: int, b: int) -> int:
    return a * b // gcd(a, b)

def mod_div(a: int, b: int, mod: int) -> int:
    return (a % mod) * pow(b, -1, mod) % mod

def mod_inv(x: int, mod: int) -> int:
    return pow(x, mod - 2, mod)

def mod_pow(b: int, e: int, mod: int) -> int:
    ans = 1
    x = b % mod
    while e != 0:
        if (e & 1) == 1:
            ans = (ans * x) % mod
        x = (x * x) % mod
        e >>= 1
    return ans

def main():
    N = int(input())
    A = [int(x) for x in input().split()]
    lcm_val = 1
    for ai in A:
        a = BigInteger(ai)
        lcm_val = lcm(lcm_val, a)
    mod = 10**9 + 7
    mod_lcm = lcm_val % mod
    ans = 0
    for ai in A:
        ans = (ans + mod_div(mod_lcm, ai, mod)) % mod
    print(ans)

if __name__ == "__main__":
    main()