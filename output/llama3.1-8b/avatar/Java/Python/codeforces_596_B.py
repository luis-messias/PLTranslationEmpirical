import sys
n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))
answer = abs(arr[0])
for i in range(1, n):
    answer += abs(arr[i] - arr[i-1])
print(answer)