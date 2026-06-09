import sys
x = input().split()
a, b = map(int, x)
c = a - b * 2
if c < 0:
    c = 0
print(c)