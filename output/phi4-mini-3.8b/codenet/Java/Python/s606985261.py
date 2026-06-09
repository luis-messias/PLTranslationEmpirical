import sys

input = iter(sys.stdin.read().splitlines()).__next__

s = next(input)
total = 0

for i in range(len(s)):
    for j in range(i + 1, len(s)):
        if s[i] == s[j]:
            total += 1

print("Yes" if total == 2 else "No")