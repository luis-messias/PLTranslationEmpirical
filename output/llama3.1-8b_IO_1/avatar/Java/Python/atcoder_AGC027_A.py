import sys
N = int(input())
x = int(input().split()[1])
sweet = []
for _ in range(N):
    a = list(map(int, input().split()))
    sweet.append(a[0])
sweet.sort()
num = 0
while num < N and x - sweet[num] >= 0:
    x -= sweet[num]
    num += 1
if num == N and x > 0:
    num -= 1
print(num)
