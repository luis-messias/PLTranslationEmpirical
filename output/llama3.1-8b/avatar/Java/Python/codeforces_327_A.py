import sys

def check_no(brr):
    val = 0
    for i in brr:
        if i == 1:
            val += 1
    return val

n = int(input())
arr = list(map(int, input().split()))

max_count = float('-inf')

for i in range(n):
    for j in range(i, n):
        brr = arr[:]
        for k in range(j + 1):
            if brr[k] == 0:
                brr[k] = 1
            else:
                brr[k] = 0
        count = check_no(brr)
        max_count = max(max_count, count)

if n == 1:
    if arr[0] == 1:
        print(0)
    else:
        print(1)
else:
    print(max_count)