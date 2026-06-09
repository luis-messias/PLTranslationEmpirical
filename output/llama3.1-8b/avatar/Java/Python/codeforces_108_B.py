import sys
import array

n = int(input())
a = array.array('i', [int(input()) for _ in range(n)])
a.sort()
for i in range(len(a) - 1):
    if a[i + 1] < a[i] * 2 and a[i] != a[i + 1]:
        print("YES")
        break
else:
    print("NO")