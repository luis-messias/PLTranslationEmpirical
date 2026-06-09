import sys
n, k = map(int, input().split())
c = 0
l = -1
for i in range(n):
    a = int(input())
    if a == l:
        c += 1
    else:
        c = 1
    l = a
if c + k > n:
    print(n - c)
else:
    print(-1)
