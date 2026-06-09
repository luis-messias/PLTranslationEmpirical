import sys
n = int(input())
list_ = []
for _ in range(n):
    line = input()
    list_.append(int(line.split()[0]))

odd = [i for i in list_ if i % 2 != 0]
sum_ = sum(i for i in list_ if i % 2 == 0)
if len(odd) % 2 != 0:
    odd.sort(reverse=True)
    sum_ -= min(odd)

print(sum_)
