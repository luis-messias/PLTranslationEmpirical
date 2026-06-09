MAX = 200000
R = [0] * MAX
n = int(input())
for i in range(n):
    R[i] = int(input())

maxv = R[1]-R[0]
minv = R[0]
for i in range(1, n):
    maxv = max(maxv, R[i]-minv)
    minv = min(minv, R[i])

print(maxv)