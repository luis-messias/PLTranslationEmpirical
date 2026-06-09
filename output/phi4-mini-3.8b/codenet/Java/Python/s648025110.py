n = int(input())
h = [int(x) for x in input().split()]

ans, out = 0, 0

for i in range(n):
    if out < h[i]:
        ans += (h[i] - out)
        out = h[i]
    else:
        out = h[i]

print(ans)