from collections import OrderedDict

n = int(input())
map_ = OrderedDict()

for _ in range(n):
    num = int(input())
    if map_.get(num) is None:
        map_[num] = 1
    else:
        key = next((k for k in map_.keys() if k < num), None)
        if key is not None and map_[key] == 1:
            del map_[key]
        elif key is not None:
            map_[key] -= 1
        map_[num] = map_.get(num, 0) + 1

ans = sum(map_.values())
print(ans)