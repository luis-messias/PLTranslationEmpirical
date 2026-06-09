def reverse(n):
    if n < 10:
        return n * 10
    r = 0
    t = n
    while t > 0:
        r = r * 10 + t % 10
        t = t // 10
    return r

n, m = map(int, input().split())
t = reverse(m)
print(t + n)
