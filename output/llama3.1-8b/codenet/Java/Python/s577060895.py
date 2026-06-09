import math

n = float(input())
sqrt = math.sqrt(n)
near_num = math.floor(sqrt)

ans = int(math.pow(near_num, 2))

print(ans)