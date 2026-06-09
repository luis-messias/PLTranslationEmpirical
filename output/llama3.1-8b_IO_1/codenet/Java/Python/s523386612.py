import sys

t = int(input())
count = [0] * (t + 1)
for _ in range(2, t):
    num = input().split()
    for n in num:
        count[int(n)] += 1
for i in range(1, t + 1):
    print(count[i])
