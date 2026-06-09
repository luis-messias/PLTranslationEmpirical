import sys
N = int(input())
A = []
for i in range(N):
    line = input()
    A.extend(map(int, line.split()))
A.sort()
for j in range(1, N):
    if A[j] == A[j-1]:
        print("NO")
        exit()
print("YES")
