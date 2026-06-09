from decimal import Decimal, getcontext

getcontext().prec = 1000

a = input()
b = input()

mul = Decimal(a) * Decimal(b)
print(int(mul))