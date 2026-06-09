import sys

n = int(input())
vec = []

for i in range(n):
    line = input().split()
    vec.append([int(line[0]), int(line[1]), int(line[2]), int(line[3])])

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
