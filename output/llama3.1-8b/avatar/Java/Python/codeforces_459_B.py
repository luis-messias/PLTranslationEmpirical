import sys

def debug(obj):
    print(str(obj))

N = int(input())
A = [int(x) for x in input().split()]
A.sort()

min_val = A[0]
max_val = A[-1]

mins = 0
maxs = 0
for value in A:
    if value == min_val:
        mins += 1
    if value == max_val:
        maxs += 1

if min_val == max_val:
    print((max_val - min_val) + " " + str(mins * (mins - 1) // 2))
else:
    print((max_val - min_val) + " " + str(mins * maxs))