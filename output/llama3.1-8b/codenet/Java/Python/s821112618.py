import re

s = ".,!? :abc:def:ghi:jkl:mno:pqrs:tuv:wxyz"
k = s.split(":")
for i in range(9):
    k[i] = list(k[i])

n = int(input())
while n > 0:
    c = input()
    l, a = -1, 0
    for char in c:
        if char != '0':
            a = ord(char) - ord('1')
            l = (l + 1) % len(k[a])
        elif l >= 0:
            print(k[a][l], end='')
            l = -1
    print()
    n -= 1