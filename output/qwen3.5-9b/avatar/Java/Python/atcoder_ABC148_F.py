import sys

sys.setrecursionlimit(200000)

def dfs(u, d, edges):
    for nu in edges[u]:
        if d[nu] == float('inf'):
            d[nu] = d[u] + 1
            dfs(nu, d, edges)

def main():
    try:
        input_data = sys.stdin.read().split()
        iterator = iter(input_data)
        
        N = int(next(iterator))
        u = int(next(iterator)) - 1
        v = int(next(iterator)) - 1
        
        edges = [[] for _ in range(N)]
        
        for _ in range(N - 1):
            a = int(next(iterator)) - 1
            b = int(next(iterator)) - 1
            edges[a].append(b)
            edges[b].append(a)
        
        d = [float('inf')] * N
        d[u] = 0
        dfs(u, d, edges)
        
        e = [float('inf')] * N
        e[v] = 0
        dfs(v, e, edges)
        
        q = -1
        for i in range(N):
            if d[i] < e[i]:
                if e[i] > q:
                    q = e[i]
        
        if q <= 0:
            print(0)
        else:
            print(q - 1)
    except:
        pass

if __name__ == "__main__":
    main()