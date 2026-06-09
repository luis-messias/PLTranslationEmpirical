n = int(input())
l = []
r = []
for _ in range(n):
    parts = input().split()
    l.append(int(parts[0]))
    r.append(int(parts[1]))
sum = 0
for i in range(n):
    sum += r[i] - l[i] + 1
print(sum)
