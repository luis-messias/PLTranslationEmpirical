import sys

N = int(input())
map_ = list(map(int, input().split())) * N

map_.sort()

max_val = sum(min(map_[i], map_[i + 1]) for i in range(0, len(map_), 2))

print(max_val)
