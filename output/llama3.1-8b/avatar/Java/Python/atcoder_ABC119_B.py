import sys

def solve(x, u):
    return sum(x[i] * (380000 if u[i] == 'JPY' else 1) for i in range(len(x)))

N = int(input())
x = [float(input()) for _ in range(N)]
u = [input() for _ in range(N)]

print(solve(x, u))