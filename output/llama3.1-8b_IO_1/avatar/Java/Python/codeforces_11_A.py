import sys

n = int(input().split()[0])
d = int(input().split()[1])

nums = []
for _ in range(n):
    nums.append(int(input().split()[0]))

result = 0
for i in range(1, n):
    a = nums[i-1] - nums[i]
    if a >= 0:
        result += (a // d) + 1
        nums[i] += ((a // d) + 1) * d

print(result)
