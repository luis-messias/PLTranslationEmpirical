import sys
n = int(input())
h = []
g = []
for _ in range(n):
    h.append(int(input()))
    g.append(int(input()))

result = sum(1 for i in h if i in g)
print(result)