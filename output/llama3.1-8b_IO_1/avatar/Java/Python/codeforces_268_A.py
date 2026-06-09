import sys
n = int(input())
h = []
g = []
for _ in range(n):
    line = input().split()
    h.append(int(line[0]))
    g.append(int(line[1]))

result = sum(1 for i in h if i in g)
print(result)
