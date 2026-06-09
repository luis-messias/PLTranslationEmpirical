import math

q = int(input())
for _ in range(q):
    n = int(input())
    x = int(math.log2(n)) + 1
    s = 2 + (n * (n + 1)) // 2 - 2 * (2 ** x)
    print(s)