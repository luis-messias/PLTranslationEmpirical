a, b, c = map(int, input().split())
x = int(input())

res = 0

for i in range(a + 1):
    for j in range(b + 1):
        for k in range(c + 1):
            total = 500 * i + 100 * j + 50 * k
            if total == x:
                res += 1
                
print(res)