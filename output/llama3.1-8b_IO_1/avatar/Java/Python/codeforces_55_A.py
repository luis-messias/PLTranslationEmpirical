import sys
n = int(input())
a = [0] * 1001
k = 1
flag = True
i = 0
while k <= n:
    i = sum(range(1, k + 1))
    while i >= n:
        i -= n
    a[i] += 1
    k += 1
for i in range(n):
    if a[i] == 0:
        flag = False
        break
print("YES" if flag else "NO")
