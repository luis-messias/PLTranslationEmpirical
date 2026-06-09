n = int(input())
g = [[0] * (n+1) for _ in range(n+1)]

for i in range(1, n + 1):
    u, k = map(int, input().split())
    for j in range(k):
        v = int(input())
        g[u][v] = 1

d = [-1] * (n+1)
que = [1]
d[1] = 0
while que:
    top = que.pop(0)
    for j in range(1, n + 1):
        if g[top-1][j] == 1 and d[j] == -1:
            que.append(j)
            d[j] = d[top-1] + 1

for i in range(1, n+1):
    print(i, d[i])
