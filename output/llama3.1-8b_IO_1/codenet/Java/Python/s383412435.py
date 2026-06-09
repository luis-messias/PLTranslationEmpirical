import sys

N = int(input())
a = list(map(int, input().split()))
for i in range(N):
    a[i] = int(a[i])

a.sort()
if N == 1 and a[0] > 1:
    ans = 1
else:
    for j in range(N):
        if j == 0 or a[j] != a[j - 1]:
            tmp = 1
            for i in range(j + 1, N):
                if a[i] == a[j]:
                    tmp += 1
                else:
                    break

            if tmp > a[j]:
                ans += tmp - a[j]
            elif tmp < a[j]:
                ans += tmp

print(ans)
