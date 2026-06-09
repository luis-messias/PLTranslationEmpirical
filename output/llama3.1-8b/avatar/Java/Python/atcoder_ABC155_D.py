import sys
import math

mod = int(1e9) + 7
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def main():
    n = int(input())
    k = int(input())
    a = list(map(int, input().split()))
    a.sort()
    inf = math.inf
    l = -inf
    r = inf
    while l + 1 < r:
        c = (l + r) // 2
        if check(c):
            l = c
        else:
            r = c
    print(l)

def check(x):
    tot = 0
    for i in range(n):
        now = a[i]
        l, r = 0, n
        if now >= 0:
            while l < r:
                c = (l + r) // 2
                if now * a[c] < x:
                    l = c + 1
                else:
                    r = c
            tot += l
        else:
            while l < r:
                c = (l + r) // 2
                if now * a[c] >= x:
                    l = c + 1
                else:
                    r = c
            tot += n - l
        if a[i]**2 < x:
            tot -= 1
    return tot // 2 < k

main()