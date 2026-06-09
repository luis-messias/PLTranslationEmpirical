import sys
input = sys.stdin.readline

a = input().rstrip()
b = input().rstrip()
print(b[::-1] + a[::-1])
