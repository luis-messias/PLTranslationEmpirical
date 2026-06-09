import sys

N = int(input())
map = [int(x) for x in input().split()]

max = 0
for i in range(0, len(map), 2):
    max += min(map[i], map[i + 1])

print(max)