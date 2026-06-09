import math
from functools import reduce

def C(n, m):
    res = math.comb(m, n)
    return res

def main():
    n, p = map(int, input().split())
    k0, k1 = 0, 0
    for _ in range(n):
        x = list(map(int, input().split()))
        if len(x) != 2:
            raise ValueError("Invalid input format")
        if x[0] % 2 == 1:
            k1 += 1
        else:
            k0 += 1

    ans = 1
    for _ in range(k0):
        ans *= 2

    if p == 0:
        add = 0
        for i in range(0, k1 + 1, 2):
            add += C(i, k1)
        ans *= add
    else:
        add = 0
        for i in range(1, k1 + 1, 2):
            add += C(i, k1)
        ans *= add

    print(ans)

main()
