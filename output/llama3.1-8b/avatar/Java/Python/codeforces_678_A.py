import sys
n, k = map(int, input().split())
n += 1
z = 0 if n % k == 0 else k - (n % k)
print(n + z)