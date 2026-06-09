import sys
n = int(input())
a, b, c = 0, 0, 0
nums = list(map(int, input().split()))
for i in range(n):
    a += nums[i]
for i in range(1, n):
    b += nums[i]
for i in range(2, n):
    c += nums[i]
x, y = a - b, b - c
print(x)
print(y)
