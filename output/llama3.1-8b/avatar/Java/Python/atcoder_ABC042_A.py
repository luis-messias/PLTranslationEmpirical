import sys
line = input()
list_ = line.split()
x, a, y = map(int, list_)
h = 'NO'
if x in [5, 7] or a in [5, 7] or y in [5, 7]:
    if x + y + a == 17:
        h = 'YES'
print(h)