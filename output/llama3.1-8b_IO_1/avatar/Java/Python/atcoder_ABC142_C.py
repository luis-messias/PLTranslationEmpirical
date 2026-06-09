from collections import defaultdict
import sys

P = []
N = int(sys.stdin.readline())
idorder = {}
for _ in range(N):
    A, _ = map(int, sys.stdin.readline().split())
    idorder[A] = _

for i in range(1, N + 1):
    print(idorder.get(i), end=' ')
