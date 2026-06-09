import sys

sc = input()
a = int(sc.split()[0])
b = int(sc.split()[1])
print("Yes" if a % 500 <= b else "No")
