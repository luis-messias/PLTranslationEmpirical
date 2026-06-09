a, b = input().split()
bStr = b.replace('.', '')
bInt = int(bStr)
result = (a * bInt) // 100
print(result)
