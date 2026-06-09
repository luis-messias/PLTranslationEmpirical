import math

a, b = map(int, input().split())
flag = False
for i in range(100000):
    if (math.floor(i * 0.08) == a and b == round(0.1 * i)):
        print(i)
        flag = True
if not flag:
    print(-1)