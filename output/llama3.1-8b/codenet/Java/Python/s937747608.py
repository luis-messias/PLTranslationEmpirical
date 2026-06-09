import sys
sc = input()
a, b, c, d = map(int, sc.split())
if a * b >= c * d:
    print(a * b)
else:
    print(c * d)