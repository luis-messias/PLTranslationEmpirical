import sys

n = int(input())
a = list(map(int, input().split()))

for k in range(n):
    for i in range(n):
        for j in range(n - 1):
            if i != j and a[k] == (a[i] + a[j]):
                print(k + 1, j + 1, i + 1)
                sys.exit()
print(-1)