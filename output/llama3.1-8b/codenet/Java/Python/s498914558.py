import sys
n, m = map(int, input().split())
po = []
for _ in range(n):
    po.append(int(input()))
    m -= po[-1]
po.sort()
print(n + m // po[0])