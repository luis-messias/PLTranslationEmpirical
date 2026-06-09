import sys
n = int(input())
a, b, c = 0, 0, 0
for _ in range(n):
    a += int(input())
for _ in range(n - 1):
    b += int(input())
for _ in range(n - 2):
    c += int(input())
x, y = a - b, b - c
print(x)
print(y)