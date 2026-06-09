import sys

# Increase recursion limit for deep DFS calls
sys.setrecursionlimit(200000)

def dfs(u, d, edges):
    """
    Performs DFS to calculate shortest distances from the starting node.
    d: distance array (passed by reference/mutable)
    edges: adjacency list
    """
    for nu in edges[u]:
        # Check if nu has not been visited (distance is still infinity)
        if d[nu] == float('inf'):
            d[nu] = d[u] + 1
            dfs(nu, d, edges)

def solve():
    # Fast input reading
    input = sys.stdin.read
    data = input().split()
    
    if not data:
        return

    N = int(data[0])
    u = int(data[1]) - 1
    v = int(data[2]) - 1
    
    data_index = 3
    
    # Initialize adjacency list
    edges = [[] for _ in range(N)]
    
    # Read N-1 edges
    for _ in range(N - 1):
        a = int(data[data_index]) - 1
        b = int(data[data_index + 1]) - 1
        data_index += 2
        
        edges[a].append(b)
        edges[b].append(a)

    # 1. Calculate distances from u (d array)
    d = [float('inf')] * N
    d[u] = 0
    dfs(u, d, edges)

    # 2. Calculate distances from v (e array)
    e = [float('inf')] * N
    e[v] = 0
    dfs(v, e, edges)

    # 3. Find q = max(e[i]) such that d[i] < e[i]
    q = -1
    for i in range(N):
        if d[i] < e[i]:
            if e[i] > q:
                q = e[i]

    # 4. Output result
    if q <= 0:
        print(0)
    else:
        print(q - 1)

if __name__ == "__main__":
    solve()