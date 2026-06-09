import math

def dist(x1, y1, x2, y2):
    return math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)

N = int(input())
pos = []
for _ in range(N):
    x, y = map(int, input().split())
    pos.append([x, y])

total = 0
for i in range(N):
    for j in range(N):
        if i == j:
            continue
        total += dist(pos[i][0], pos[i][1], pos[j][0], pos[j][1])

print(total / N)