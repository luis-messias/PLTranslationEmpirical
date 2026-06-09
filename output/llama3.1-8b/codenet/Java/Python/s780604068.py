import sys

N = int(input())
map_ = [int(x) for x in input().split()] * 2

map_.sort()

max_val = sum(min(map_[i], map_[i + 1]) for i in range(0, N * 2, 2))

print(max_val)