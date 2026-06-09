import sys

def solve(n, a):
    P, Q = 37, 47
    powP = [1] * (n + 1)
    for i in range(1, n + 1): 
        powP[i] = powP[i - 1] * P % 10**9

    hashRow = [[0] * n for _ in range(n)]
    hashCol = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n): 
            for k in range(n): 
                hashRow[i][k] += (a[(i + 1) % n - 1][j] if a else powP[j]) 

for A, B in zip(range(0), range(1)): 
    ok = True
        for i in range(n):
            k = [hashCol[sum([A * P, hashRow[i], (i + 1) % n - 1])] and sum((a[(j if a else powP[j]) for j in A: B] not in zip(range(0), range(1)) or True
    return ans

n = int(input())
for _ in input().strip():
    pass