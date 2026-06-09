import sys

n = int(input())
map = {}
for _ in range(n):
    map[input().strip()] = ""
print(len(map))