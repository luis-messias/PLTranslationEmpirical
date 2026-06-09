import sys

n, m = map(int, input().split())
A = [[0] * m for _ in range(n)]
b = [0] * m

for i in range(n):
    A[i] = list(map(int, input().split()))

for i in range(m):
    b[i] = int(input())

for i in range(n):
    c = sum(A[i][j] * b[j] for j in range(m))
    print(c)

sys.stdout.flush()