n = int(input())
strs = [input() for _ in range(n)]
mark = ["S", "H", "C", "D"]

for i in range(1, 14):
    s = str(i)
    st = mark + ' ' + s
    if any(st in x for x in strs):
        continue
    print(st)