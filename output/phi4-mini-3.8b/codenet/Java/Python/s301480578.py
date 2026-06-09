n = int(input())
h = list(map(int, input().split()))
max_count = 0

for i in range(n - 1):
    current_count = 0
    while (i < n - 1) and (h[i] >= h[i + 1]):
        i += 1
        current_count += 1
    max_count = max(max_count, current_count)

print(max_count)