import sys

def get_gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

a = [int(x) // 2 for x in sys.stdin.readline().split()]
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
