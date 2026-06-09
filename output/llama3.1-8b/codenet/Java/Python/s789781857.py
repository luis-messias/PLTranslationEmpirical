import sys

n = int(input())
c = [0] * (n - 1)
s = [0] * (n - 1)
f = [0] * (n - 1)

for i in range(n - 1):
    c[i] = int(input())
    s[i] = int(input())
    f[i] = int(input())

for i in range(n - 1):
    time = s[i] + c[i]
    for j in range(i + 1, n - 1):
        if time % f[j] != 0:
            time += f[j] - (time % f[j])
        if time < s[j]:
            time = s[j]
        time += c[j]
    print(time)

print(0)