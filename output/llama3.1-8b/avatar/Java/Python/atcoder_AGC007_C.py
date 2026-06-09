import decimal

N = int(input())
d = float(input())
x = float(input())

ans = decimal.Decimal('0.0')
while N > 0.5:
    adnum = d + x * (N - 0.5)
    ans += decimal.Decimal(str(adnum))
    d = ((N + 1) * d / N) + ((5 * x) / (2 * N))
    x = (1 + (2 / N)) * x
    N -= 1

format = "{:.20f}".format(ans)
print(format)