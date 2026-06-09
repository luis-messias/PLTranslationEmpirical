h, a = map(int, input().split())
num = 0
while h > 0:
    h -= a
    num += 1
print(num)
