x, a, y = map(int, input().split())
h = "NO"
if (x == 5 or x == 7 or a == 5 or a == 7 or y == 5 or y == 7) and (x + y + a == 17):
    h = "YES"
print(h)
