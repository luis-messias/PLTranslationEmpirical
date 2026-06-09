import math
import sys

n = int(sys.stdin.read().strip())

sqrt_n = math.sqrt(n)
near_num = math.floor(sqrt_n)

ans = near_num * near_num

print(ans)