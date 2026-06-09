N = int(input())
s = input()

ans = 0
sha = 0
dot = 0

for char in s:
    if char == '#':
        sha += 1
    else:
        dot += 1

if sha <= dot:
    ans += sha
    dot = 0

print(ans + dot)
