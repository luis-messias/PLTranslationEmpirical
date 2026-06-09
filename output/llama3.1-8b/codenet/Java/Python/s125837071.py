import math

def find_s(k, i):
    s = 0
    while k % i == 0:
        s += 1
        k //= i
    return s

mod = int(math.pow(10, 9)) + 7

n = int(input())
ans = 1
for i in range(2, n+1):
    for j in range(2, i):
        if i % j != 0:
            break
    else:
        s = sum(find_s(k, i) for k in range(1, n+1))
        ans = (ans * (s + 1)) % mod

print(ans)