import math
from functools import reduce

def gcd(a: int, b: int) -> int:
    while b != 0:
        a, b = b, a % b
    return a

def lcm(a: int, b: int) -> int:
    return a * b // gcd(a, b)

def mod_div(a: int, b: int, mod: int) -> int:
    return (a % mod) * pow(b, -1, mod) % mod

def main():
    N = int(input())
    A = [int(x) for x in input().split()]
    lcm_val = 1
    for ai in A:
        a = abs(ai)
        lcm_val = lcm(lcm_val, a)
    mod = 10**9 + 7
    mod_lcm = lcm_val % mod
    ans = 0
    for ai in A:
        ans = (ans + mod_div(mod_lcm, abs(ai), mod)) % mod
    print(ans)

if __name__ == "__main__":
    main()
