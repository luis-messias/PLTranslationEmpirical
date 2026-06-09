import sys

N = int(input())
P = [int(x) - 1 for x in input().split()]

map_ = {}
for i, p in enumerate(P):
    map_[p] = i

nglist = []
for i in range(N-1):
    if map_[i] > map_[i+1]:
        nglist.append(i)

if not nglist:
    print(0)
else:
    ans = min(N - nglist[0] - 1, nglist[-1] + 1)
    for i in range(len(nglist) - 1):
        ans = min(nglist[i] + 1 + N - nglist[i+1] - 1, ans)

    print(ans)