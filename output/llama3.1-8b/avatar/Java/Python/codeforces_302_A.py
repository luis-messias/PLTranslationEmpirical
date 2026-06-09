import sys

n, k = map(int, input().split())
arr = list(map(int, input().split()))

o, e = 0, 0
for num in arr:
    if num == 1:
        o += 1
    else:
        e += 1

res = []
for _ in range(k):
    l, r = map(int, input().split())
    if (r - l + 1) % 2 == 1:
        res.append("0\n")
    else:
        if (r - l + 1) // 2 <= o and (r - l + 1) // 2 <= e:
            res.append("1\n")
        else:
            res.append("0\n")

print(''.join(res))