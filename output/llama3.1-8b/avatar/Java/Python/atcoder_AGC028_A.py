import math
from itertools import zip_longest

n, m = map(int, input().split())
gcd = math.gcd(n, m)
s, t = input(), input()

result = next((k for k in range(gcd) if s[k * n // gcd] != t[k * m // gcd]), None)

if result is not None:
    print(-1)
else:
    print(n * m // gcd)