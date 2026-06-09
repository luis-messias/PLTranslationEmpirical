import math
from decimal import Decimal, getcontext

getcontext().prec = 50

A, B, H, M = map(int, input().split())

AA = Decimal(A)
BB = Decimal(B)
HH = Decimal(H)
MM = Decimal(M)

mkaku = MM * 6
hkaku = HH * 30 + M / 2
kaku = mkaku - hkaku

dkaku = abs(math.radians(kaku))

AA2 = AA ** 2
BB2 = BB ** 2
CC = AA2 + BB2
DD = Decimal(2) * math.cos(dkaku) * AA * BB
ans2 = CC - DD
dans2 = ans2

ans = math.sqrt(dans2)
print(ans)
