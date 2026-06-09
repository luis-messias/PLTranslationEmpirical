t = int(input())
count = [0] * (t + 1)
for _ in range(t):
    x = int(input())
    count[x - 1] += 1

for i in range(1, t + 1): 
    print(count[i])