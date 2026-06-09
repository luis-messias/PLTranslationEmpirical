import string

s = input()
k = int(input())
sb = []

for c in s:
    if (26 - (ord(c) - ord('a')) <= k and c != 'a'):
        k -= 26 - (ord(c) - ord('a'))
        sb.append('a')
    else:
        sb.append(c)

if k > 0:
    t = sb[-1]
    sb.pop()
    sb.append(chr(ord('a') + (ord(t) - ord('a') + k) % 26))

print(''.join(sb))