s = input()
from collections import Counter
count = Counter(s)
ok = all(v == 2 for v in count.values())
if ok and len(count) == 2:
    print("Yes")
else:
    print("No")
