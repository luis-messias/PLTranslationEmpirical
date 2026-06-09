import math
import sys

n = int(input())
a = [0, 0, 0]

for _ in range(n):
    a[0], a[1], a[2] = map(int, input().split())
    a.sort()
    if math.pow(a[2], 2) == math.pow(a[0], 2) + math.pow(a[1], 2):
        print("YES")
    else:
        print("NO")