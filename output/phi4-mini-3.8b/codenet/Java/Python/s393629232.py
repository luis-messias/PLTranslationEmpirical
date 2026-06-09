n = int(input())
maxv = float('-inf')
minv = int(input())

for _ in range(n - 1):
    r_i = int(input())
    maxv = max(maxv, r_i - minv)
    minv = min(minv, r_i)

print(maxv)