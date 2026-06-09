import math
import sys

def dist(x1, y1, x2, y2):
    return math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)

N = int(input())
pos = [[0, 0] for _ in range(N)]

for i in range(N):
    pos[i][0], pos[i][1] = map(int, input().split())

sum_dist = 0
for i in range(N):
    for j in range(N):
        if i == j:
            continue
        sum_dist += dist(pos[i][0], pos[i][1], pos[j][0], pos[j][1])

print(sum_dist / N)