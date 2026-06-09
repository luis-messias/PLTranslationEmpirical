import sys

s = False
n = input()

for char in n:
    if char == '.':
        if s:
            print(1, end='')
            s = False
        else:
            print(0, end='')
    else:
        if s:
            print(2, end='')
            s = False
        else:
            s = True

print()
