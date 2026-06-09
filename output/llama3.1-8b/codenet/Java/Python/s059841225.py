import sys

for line in sys.stdin:
    str = line.strip()
    strArr = str.split(",")
    l = [int(i) for i in strArr[:-2]]
    d = sum(l)
    v = [int(strArr[-2]), int(strArr[-1])]
    t = (d / (v[0] + v[1]))
    d = 0
    for i, val in enumerate(l):
        if v[0]*t <= d:
            print(i)
            break
        else:
            d += l[i]