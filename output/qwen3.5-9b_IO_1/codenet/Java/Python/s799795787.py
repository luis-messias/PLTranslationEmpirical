n = int(input())
array = [input() for _ in range(n)]
array.sort()

cnt = 0
if n > 0:
    a = array[0]
    cnt = 1
    for i in range(n):
        if a != array[i]:
            cnt += 1
            a = array[i]

print(cnt)
