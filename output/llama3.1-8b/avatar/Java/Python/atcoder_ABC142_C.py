from collections import defaultdict

P = []
N = int(input())
idorder = defaultdict(int)
for _ in range(N):
    A = int(input())
    idorder[A] = _

for i in range(1, N + 1):
    print(idorder[i], end=' ')