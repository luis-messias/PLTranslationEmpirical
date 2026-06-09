import sys

s = sys.stdin.read().strip()
total = 0
n = len(s)

for i in range(n):
    for j in range(i + 1, n):
        if s[i] == s[j]:
            total += 1

if total == 2:
    print("Yes")
else:
    print("No")