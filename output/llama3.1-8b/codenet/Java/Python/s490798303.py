from collections import defaultdict

n, k = map(int, input().split())

map_ = defaultdict(list)

for _ in range(k):
    d = int(input())
    for _ in range(d):
        person = int(input())
        map_[person].append(d)

count = 0
for i in range(1, n + 1):
    if i not in map_:
        count += 1

print(count)