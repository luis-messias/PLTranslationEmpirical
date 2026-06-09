import sys

md = []
n = int(input())
a = [0] * n
b = [0] * n
temp = 0
q = 0
w = 0
e = 0
f = False

for i in range(n):
    line = input().split()
    a[i] = int(line[0])
    b[i] = int(line[1])

    if temp < a[i]:
        if q > b[i]:
            f = True
        q = b[i]
        temp = a[i]

    elif temp > a[i]:
        if q < b[i]:
            f = True
        q = b[i]
        temp = a[i]

    if a[i] > w:
        w = a[i]
        if b[i] < e:
            f = True
        e = b[i]

    elif a[i] < w:
        if b[i] > e:
            f = True

if f == True:
    print("Happy Alex")
else:
    print("Poor Alex")
