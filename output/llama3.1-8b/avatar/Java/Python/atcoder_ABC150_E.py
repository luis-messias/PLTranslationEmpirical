import sys
import math

def power(x, n):
    if n == 0:
        return 1
    mod = 10**9 + 7
    val = power(x, n // 2)
    val = (val * val) % mod
    if n % 2 == 1:
        val = (val * x) % mod
    return val

def main():
    sa = input().split()
    n = int(sa[0])
    c = list(map(int, input().split()))
    mod = 10**9 + 7
    if n == 1:
        print((c[0] * 2) % mod)
        return
    c.sort()
    b = power(2, n)
    a = power(2, n - 2)
    ans = 0
    for i in range(2, n + 2):
        val = (a * i) % mod
        val *= c[n - i]
        val %= mod
        ans += val
        ans %= mod
    ans *= b
    ans %= mod
    print(ans)

if __name__ == "__main__":
    main()