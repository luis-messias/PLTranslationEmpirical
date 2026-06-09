import sys

w, h, n = map(int, input().split())
x = list(map(int, input().split()))
y = [int(input()) for _ in range(n)]
a = [0] * n  # Assuming 'a' is not used as per the original code logic.

xmin, xmax = -sys.maxsize, sys.maxsize
ymin, ymax = -sys.maxsize, sys.maxsize

for i in range(n):
    x[i], y[i], a[i] = map(int, input().split())
    
    if a[i] == 1:
        xmin = max(xmin, x[i])
    elif a[i] == 2:
        xmax = min(xmax, x[i])
    elif a[i] == 3:
        ymin = max(ymin, y[i])
    elif a[i] == 4:
        ymax = min(ymax, y[i])

w = max(0, xmax - xmin)
h = max(0, ymax - ymin)

print(w * h)