def split(n, k):
    sum = 0
    while n > 0:
        sum += n % k
        n //= k
    return sum

def solve(n, s):
    for k in range(2, min(int(n**0.5) + 1, 100)):
        if split(n, k) == s:
            return k
    while True:
        a = n // (k := n // (a := int(n**0.5)) + 1)
        b = n % (k - 1)
        if (a + b - s) % a == 0:
            dk = (a + b - s) // a
            if dk >= 0 and b - dk * a >= 0:
                return k + dk
    if n == s:
        return n+1
    return -1

import sys
nl, sl = map(int, input().split())
print(solve(nl, sl))