import sys

n = int(input())
ans = []
for _ in range(n):
    ans.append(int(input()))

ans.sort(reverse=True)
count = 0
for i in range(1, n):
    if ans[i] < ans[i-1]:
        count += ans[i]
    else:
        while ans[i] >= ans[i-1]:
            ans[i] -= 1
        if ans[i] > 0:
            count += ans[i]

print(count)