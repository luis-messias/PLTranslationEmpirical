n = int(input())
a = list(map(int, input().split())

swap_count = 0

for i in range(n):
    mini = i
    
    for j in range(i, n):
        if a[j] < a[mini]:
            mini = j
            
    if (mini != i):
        v = a[mini]
        a[mini], a[i] = a[i], v
        swap_count += 1

ans = str(a[0])
for i in range(1, n):
    ans += " " + str(a[i])

print(ans)
print(swap_count)