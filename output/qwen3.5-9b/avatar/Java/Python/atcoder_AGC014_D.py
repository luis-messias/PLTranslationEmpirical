import sys
sys.setrecursionlimit(200000)

def solve():
    input_data = sys.stdin.read().split()
    ptr = 0
    
    n = int(input_data[ptr])
    ptr += 1
    
    g = [[] for _ in range(n)]
    
    for _ in range(n - 1):
        a = int(input_data[ptr]) - 1
        b = int(input_data[ptr + 1]) - 1
        ptr += 2
        g[a].append(b)
        g[b].append(a)
    
    def max_matching(v, p):
        a = 0
        o = 0
        for w in g[v]:
            if w == p:
                continue
            r = max_matching(w, v)
            a += r // 2
            o += r % 2
        return 2 * a + min(1, o) + 1
    
    m = max_matching(0, -1) // 2
    
    if 2 * m == n:
        print("Second")
    else:
        print("First")

solve()