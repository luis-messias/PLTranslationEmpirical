import math

def find_s(k, i):
    s = 0
    while k % i == 0:
        s += 1
        k //= i
    return s

n = int(input())
ans = 1
mod = pow(10, 9) + 7
for i in range(2, n+1):
    for j in range(2, min(i, (i % j != 0 and j < i)) or j == i):
        if j == i:
            s = sum(find_s(k, i) for k in range(1, n + 1))
            ans *= (s + 1)
            ans %= mod

print(ans)