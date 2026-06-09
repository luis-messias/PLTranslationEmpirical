N = int(input())
count, next_val = 0, 10

for i in range(1, N + 1):
    count += 1
    if i == (next_val - 1) % 100:
        next_val *= 100
        
print(count)