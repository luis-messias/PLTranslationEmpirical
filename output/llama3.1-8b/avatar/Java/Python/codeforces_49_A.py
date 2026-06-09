import re

s = input()
length = len(s)
ch = 0
for i in range(length - 1, -1, -1):
    if s[i] not in [' ', '?']:
        ch = s[i]
        break
ch = ch.lower()
if ch in 'aeiouy':
    print("YES")
else:
    print("NO")