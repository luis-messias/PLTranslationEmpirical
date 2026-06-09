N, Q = map(int, input().split())
s = input()
pre = [0] * (N + 1)

for i in range(1, N):
    if s[i-1] == 'A' and s[i] == 'C':
        pre[i] = 1

# Building the prefix sum array
for i in range(1, N):
    pre[i] += pre[i - 1]

while Q > 0:
    l, r = map(int, input().split())
    print(pre[r-1] - (pre[l-2] if l > 1 else 0))