import sys
def max_left(n):
    return n > 2 and n - 2 or 0

t = int(input())
for _ in range(t):
    n = int(input())
    print(max_left(n))