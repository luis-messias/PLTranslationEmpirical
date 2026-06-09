import sys

n = int(input())
vec = [[0, 0, 0, 0] for _ in range(n)]

for i in range(n):
    vec[i][0] = int(input())
    vec[i][1] = int(input())
    vec[i][2] = int(input())
    vec[i][3] = int(input())

ans = 500
ansprice = 20000

for i in range(n):
    fl = True
    for j in range(n):
        if (vec[i][0] < vec[j][0] and vec[i][1] < vec[j][1] and vec[i][2] < vec[j][2]):
            fl = False
    if fl:
        if vec[i][3] < ansprice:
            ansprice = vec[i][3]
            ans = i + 1

print(ans)