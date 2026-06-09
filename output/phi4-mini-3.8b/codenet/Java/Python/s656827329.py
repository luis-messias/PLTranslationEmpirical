n = int(input())
a = [int(x) for x in input().split()]

count, now, befor = 1, 0

for i in range(1, n):
    if a[i - 1] < a[i]:
        now = 1
    elif a[i - 1] > a[i]:
        now = -1
    else:
        continue
    
    if before == 0 and (now != befor or count >= 2) and not after:
        forbe, count += 1

print(count)