import sys

N = int(input())
M = int(input())

H = [0] * N
ans = [True] * N

for i in range(N):
    H[i], = map(int, input().split())
    ans[i] = True

for _ in range(M):
    temp1, temp2 = map(int, input().split())
    if H[temp1-1] < H[temp2-1]:
        ans[temp1-1] = False
    elif H[temp1-1] > H[temp2-1]:
        ans[temp2-1] = False
    else:
        ans[temp1-1] = False
        ans[temp2-1] = False

ans2 = sum(1 for x in ans if x)
print(ans2)
