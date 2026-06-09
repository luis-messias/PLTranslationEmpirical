from collections import deque

n, m = map(int, input().split())
q1 = deque()
q2 = deque()

for _ in range(n):
    q1.append(int(input()))
    q2.append(_ + 1)

ans = 0
while q1:
    if q1[0] <= m:
        ans = q2.popleft()
        q1.popleft()
    else:
        x = q1.popleft()
        val = x - m
        q1.append(val)
        q2.pop()

print(ans)