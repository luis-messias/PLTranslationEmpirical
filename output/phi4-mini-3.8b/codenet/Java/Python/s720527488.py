import sys

def input():
    return map(int, next().split())

m = 1 + (input())
n = int(input())
manju = list(map(int, input().split()))
boxlen = [0] * n
boxcost = [0] * n
for i in range(n):
    boxlen[i], boxcost[i] = map(int, input().split())

def sort(a):
    for i in range(len(a) - 1, 0, -1):
        t = (int)(i)
        a[t], a[--t] = a[--t]
    a.sort()

sort(manju)

dp = [[-inf for _ in range(n + 1)] for __ in range(2)]
for i in reversed(range(len(manju))):
    for j in reversed(range(len(boxlen) - 1)):
        len_ij, count = (i + boxlen[j]) if (i + boxlen[j] < m else i), sum(manju[--k] for k in range(i))
        dp[i][j], max_val = [max(dp[len_ij and j or l + 1 - (l > len( --boxcost) ) : count - boxcost[l]], 
                                dp[i if not (i < m else i + boxlen[j]) and sum(manju[--k] for k in range(i))])

sys.stdout.write(str(dp[0][0]))