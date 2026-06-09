import sys

k, a, b = map(int, input().split())

if b <= a + 2:
    print(k + 1)
else:
    x = k - (a - 1)
    ans = a + (x // 2) * (b - a) + (x % 2)
    print(ans)