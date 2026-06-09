import sys

def solve():
    a = int(input())
    b = int(input())

    if (a - 2*b) < 0:
        print(max(0, a-2*b))
    else:
        max_val = 0
        for i in range(n):
            s[i] = input()
        roads = [[1]*n for _ in range(n)]
        m = int(input())
        for _ in range(m):
            p, q = map(int, input().split())
            if (p < n and q < n) or (q - 1 >= 0 and p - 1 >= 0): 
                roads[p-1][q-1] = 1
                roads[q-1][p-1] = 1

        for i in range(n):
            print(' '.join(map(str, [roads[i][j] for j in range(n)]))
        
        start = int(input()) - 1
        
        max_val = find_roads(roads, s, start)
        if (max_val > 0) and not roads[start]:
            sys.exit()