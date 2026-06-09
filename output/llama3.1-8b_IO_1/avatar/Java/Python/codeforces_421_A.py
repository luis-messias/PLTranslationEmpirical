import sys

n, a, b = map(int, input().split())
list1 = []
list2 = []

for _ in range(a):
    list1.append(map(int, input().split()))

for _ in range(b):
    list2.append(map(int, input().split()))

result = [1 if i + 1 in set(list1[0]) else 2 for i in range(n)]
print(*result)
