import sys

def solve(x, u):
    return sum(x[i] * (380000 if u[i] == 'JPY' else 1) for i in range(len(x)))

N = int(input())
x = []
u = []

for _ in range(N):
    line = input().split()
    x.append(float(line[0]))
    u.append(line[1])

print(solve(x, u))
