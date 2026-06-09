import sys

def check(x, n, k, a):
    tot = 0
    for i in range(n):
        now = a[i]
        l = 0
        r = n
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
            tot += (n - l)
        if a[i] * a[i] < x:
            tot -= 1
    
    return tot // 2 >= k

def main():
    input = sys.stdin.read
    data = input().split()
    n = int(data[0])
    k = int(data[1])
    a = list(map(int, data[2:2+n]))
    a.sort()
    
    INF = 10**18 + 1
    l = -INF
    r = INF
    
    while l + 1 < r:
        c = (l + r) // 2
        if check(c, n, k, a):
            l = c
        else: