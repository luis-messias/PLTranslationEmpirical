import sys

def power(a, b, m):
    res = 1
    a %= m
    while b > 0:
        if b % 2 == 1:
            res = (res * a) % m
        a = (a * a) % m
        b //= 2
    return res

def modInverse(n, m):
    # Using Fermat's Little Theorem: n^(m-2) % m
    return power(n, m - 2, m)

def gcd(a, b):
    while b:
        a, b = b, a % b
