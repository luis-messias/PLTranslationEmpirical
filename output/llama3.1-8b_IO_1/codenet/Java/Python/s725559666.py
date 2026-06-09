import sys

a = int(input().split()[0])
b = int(input().split()[0])
c = int(input().split()[0])

if a < b and b < c:
    print("Yes")
else:
    print("No")
