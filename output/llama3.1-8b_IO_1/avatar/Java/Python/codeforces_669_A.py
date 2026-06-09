import sys
def solve(n):
    print(((n // 3) * 2) + ((n % 3) != 0))

try:
    n = int(input())
    solve(n)
except Exception as e:
    print(e)
