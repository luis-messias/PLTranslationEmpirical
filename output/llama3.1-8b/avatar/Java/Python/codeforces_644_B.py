from collections import deque

n, b = map(int, input().split())
ans = [-1] * n
q = deque()

for _ in range(n):
    t, d = map(int, input().split())
    while q and q[0] <= t:
        q.popleft()
    if len(q) < b:
        ans[_] = (t if not q else q[-1]) + d
        q.append(ans[_])
    else:
        ans[_] = -1

print(*ans)