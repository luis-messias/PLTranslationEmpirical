n = int(input())
v = list(map(int, input().split()))
c = list(map(int, input().split()))

max_profit = 0
for i in range(n):
    profit = v[i] - c[i]
    if profit > 0:
        max_profit += profit

print(max_profit)
