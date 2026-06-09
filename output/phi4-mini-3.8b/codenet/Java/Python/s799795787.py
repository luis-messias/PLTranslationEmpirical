n = int(input())
array = [input() for _ in range(n)]
array.sort()

a, count1 = 0, 0

for i in range(n):
    if a == array[i]:
        pass
    else:
        count1 += 1
    a = array[i]

print(count1)