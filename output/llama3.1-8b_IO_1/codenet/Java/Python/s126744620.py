n, k = map(int, input().split())
a = list(map(int, input().split()))
x = [0] * (max(a) + 10)
for num in a:
    x[num - 1] += 1
x.sort(reverse=True)
ans = sum(x[:k])
print(ans)
