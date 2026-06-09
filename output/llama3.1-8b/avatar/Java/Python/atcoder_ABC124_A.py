import sys
sc = sys.stdin.readline
a, b = map(int, sc().split())
sum_val = 0
for i in range(2):
    if a >= b:
        sum_val += a
        a -= 1
    else:
        sum_val += b
        b -= 1
print(sum_val)