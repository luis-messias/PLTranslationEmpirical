import math

A = []
N = int(input())
for i in range(N):
    line = input()
    A.append(int(line.split()[0]))

M = [0] * N
L = [0] * N
R = [0] * N
L[0] = A[0]
for i in range(1, N):
    L[i] = math.gcd(L[i-1], A[i])

R[N-1] = A[N-1]
for i in range(N-2, -1, -1):
    R[i] = math.gcd(R[i+1], A[i])

answer = max(L[-2], R[1])
for i in range(1, N-1):
    answer = max(answer, math.gcd(L[i-1], R[i+1]))

print(answer)
