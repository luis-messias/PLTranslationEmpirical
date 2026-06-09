import sys

n = int(input())
N = 100005
cnt = [0] * 21

for _ in range(n):
    num = int(input()) + 10
    if 0 <= num < N:
        cnt[num] += 1

res = 0
for i in range(11):
    res += cnt[i] * cnt[20 - i]

print(res)
