import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))

result, pos = 0, 0
if a[0] > 15:
    result = 15
else:
    flag = False
    for i in range(1, n):
        if a[i] - a[i-1] > 15:
            pos = i - 1
            flag = True
            break
    if flag:
        result = a[pos] + 15
    else:
        result = a[-1] + 15

if result > 90:
    result = 90

print(result)
