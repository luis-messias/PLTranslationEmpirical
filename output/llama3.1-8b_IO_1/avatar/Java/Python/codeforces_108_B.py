import sys
n = int(input())
a = [int(x) for x in input().split()] * n
a.sort()
for i in range(len(a) - 1):
    if a[i + 1] < a[i] * 2 and a[i] != a[i + 1]:
        print("YES")
        break
else:
    print("NO")
