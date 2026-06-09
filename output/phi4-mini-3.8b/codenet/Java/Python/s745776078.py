import sys

n, m = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]
b = list(map(int, input().split())

for i in A:
    c = 0
    for j in b:
        c += sum([i[j] * x for x in b])
    print(c)