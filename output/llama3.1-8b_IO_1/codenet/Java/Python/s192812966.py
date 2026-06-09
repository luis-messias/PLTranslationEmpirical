import sys

n = int(input().split()[0])
xmin, xmax = float('inf'), -float('inf')
ymin, ymax = float('inf'), -float('inf')

for _ in range(n):
    x, y, a = map(int, input().split())
    if a == 1:
        xmin = min(xmin, x)
    elif a == 2:
        xmax = max(xmax, x)
    elif a == 3:
        ymin = min(ymin, y)
    elif a == 4:
        ymax = max(ymax, y)

w, h = max(xmax - xmin, 0), max(ymax - ymin, 0)
print(w * h)
