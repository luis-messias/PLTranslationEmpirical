import sys
from math import ceil

sc = input()
N = int(sc)
min_val = 0
for _ in range(5):
    if _ == 0:
        min_val = int(input())
    else:
        min_val = min(min_val, int(input()))

print(int(ceil(N / min_val)) + 4)