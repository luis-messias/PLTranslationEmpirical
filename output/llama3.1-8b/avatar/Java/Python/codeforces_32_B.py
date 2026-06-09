import sys

n = input()
s = False
for c in n:
    if c == '.':
        print(1 if s else 0)
        s = False
    else:
        print(2 if s else 1, end='')
print()