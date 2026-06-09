from collections import defaultdict

s = input()
targ = list(s)
map_ = defaultdict(int)

for i in range(len(targ)):
    if targ[i] not in map_:
        map_[targ[i]] = 1
    else:
        map_[targ[i]] += 1

ok = True
for c, v in map_.items():
    if v != 2:
        ok = False
        break

if ok and len(map_) == 2:
    print("Yes")
else:
    print("No")