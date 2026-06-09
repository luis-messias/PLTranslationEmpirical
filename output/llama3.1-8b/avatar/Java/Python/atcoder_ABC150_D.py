import math

def get_gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

n = int(input())
m = int(input())

a = [int(input()) // 2 for _ in range(n)]

gcd = None
lcd = 1
for i in a:
    gcd = get_gcd(lcd, i)
    lcd = (lcd * i) // gcd
    if lcd > m:
        print(0)
        exit()

for i in a:
    if (lcd // i) % 2 == 0:
        print(0)
        exit()

print((m // lcd + 1) // 2)