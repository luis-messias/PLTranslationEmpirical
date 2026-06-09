import sys

n = int(input())
list_ = []
for _ in range(n):
    list_.append(int(input()))

odd = [i for i in list_ if i % 2 != 0]
sum_ = sum(i for i in list_ if i % 2 == 0)
if len(odd) % 2 != 0:
    odd.sort()
    sum_ -= min(odd)

print(sum_)