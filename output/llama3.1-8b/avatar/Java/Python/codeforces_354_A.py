import sys

N, L, R, QL, QR = map(int, input().split())
W = [int(x) for x in input().split()]
sums = [0] * (N + 1)
for n in range(N):
    sums[n+1] = sums[n] + W[n]

min_val = sys.maxsize
for firstR in range(N + 1):
    lCount, rCount = firstR, N - firstR
    cand = L * sums[lCount] + R * (sums[N] - sums[lCount])
    llCount, rrCount = max(0, lCount - rCount - 1), max(0, rCount - lCount - 1)
    cand += QL * llCount + QR * rrCount
    min_val = min(min_val, cand)

print(min_val)