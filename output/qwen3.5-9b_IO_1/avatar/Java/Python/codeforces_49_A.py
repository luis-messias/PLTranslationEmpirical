import sys

s = sys.stdin.readline()
ch = ''
for i in range(len(s) - 1, -1, -1):
    if s[i] != ' ' and s[i] != '?':
        ch = s[i]
        break

ch = ch.lower()
if ch in ['a', 'e', 'i', 'o', 'u', 'y']:
    print("YES")
else:
    print("NO")
