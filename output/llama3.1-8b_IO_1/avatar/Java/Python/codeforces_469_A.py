import sys
n = int(input())
levels = int(input())
arr = []
for i in range(levels):
    arr.append(int(input()))
level2 = int(input())
level3 = levels + level2
arr2 = [0] * level3
for i in range(len(arr)):
    arr2[i] = arr[i]
for i in range(len(arr), level3):
    arr2[i] = int(input())
count = 0
arr3 = []
j = 0
for i in range(n):
    j += 1
    arr3.append(j)
for i in range(n):
    for x in range(level3):
        if arr3[i] == arr2[x]:
            count += 1
            break
if count == n:
    print("I become the guy.")
else:
    print("Oh, my keyboard!")
