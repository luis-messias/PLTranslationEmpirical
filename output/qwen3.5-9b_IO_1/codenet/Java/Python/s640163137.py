n = int(input())
a = list(map(int, input().split()))
swapCount = 0
for i in range(n):
    mini = i
    for j in range(i, n):
        if a[j] < a[mini]:
            mini = j
    if mini != i:
        a[i], a[mini] = a[mini], a[i]
        swapCount += 1
print(*(a))
print(swapCount)
