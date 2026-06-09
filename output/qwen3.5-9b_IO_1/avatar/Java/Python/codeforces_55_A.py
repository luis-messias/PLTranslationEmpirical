n = int(input())
i = 0
k = 0
a = [0] * 1000
flag = True

while k <= n:
    i += k
    while i >= n:
        i -= n
    a[i] += 1
    k += 1

for i in range(n):
    if a[i] == 0:
        flag = False
        break

if flag:
    print("YES")
else:
    print("NO")
