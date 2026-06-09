import sys

n = int(input())
arr = list(map(int, input().split()))
cnt = 0
flag = True

while flag:
    for i in range(n):
        if arr[i] % 2 != 0:
            flag = False
            break
        else:
            arr[i] //= 2
    cnt += 1
    
print(cnt)