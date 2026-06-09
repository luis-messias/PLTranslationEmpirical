import sys

n, k = map(int, input().split())
c = 0
for i in range(n):
    a = int(input())
    if a == c:
        c += 1
    else:
        c = 1
    if c + k > n:
        print(n - c)
        break
else:
    print(-1)