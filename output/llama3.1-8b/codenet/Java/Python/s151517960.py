from collections import defaultdict

n = int(input())
map_ = defaultdict(int)
for _ in range(n):
    a = int(input())
    map_[a] += 1
ans = sum(1 for key, value in map_.items() if value % 2 == 1)
print(ans)