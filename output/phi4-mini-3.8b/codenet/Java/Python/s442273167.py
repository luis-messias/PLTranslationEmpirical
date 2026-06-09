n = int(input())
l = [int(x) for x in input().split()]
r = [int(x) for x in input().split()]

sum_result = 0

for i in range(n):
    sum_result += (r[i] - l[i]) + 1

print(sum_result)