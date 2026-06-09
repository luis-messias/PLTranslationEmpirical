import sys

n, a, b = map(int, input().split())
list1 = []
list2 = []

for _ in range(a):
    list1.append(int(input()))

for _ in range(b):
    list2.append(int(input()))

result = [1 if i + 1 in list1 else 2 for i in range(n)]
print(*result)