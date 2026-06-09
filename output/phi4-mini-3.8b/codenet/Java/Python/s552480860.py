h1, m1 = map(int, input().split())
h2, m2 = map(int, input().split())
k = int(input())

t1 = h1 * 60 + m1
t2 = h2 * 60 + m2

print(t2 - t1 - k)