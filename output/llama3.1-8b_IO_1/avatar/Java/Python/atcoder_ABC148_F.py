from typing import List
import sys

def main():
    N, u, v = map(int, input().split())
    u -= 1
    v -= 1
    edges = [[] for _ in range(N)]
    for i in range(N - 1):
        a, b = map(int, input().split())
        a -= 1
        b -= 1
        edges[a].append(b)
        edges[b].append(a)

    d = [float('inf')] * N
    d[u] = 0
    visited = set()
    dfs(u, d, edges, visited)

    e = [float('inf')] * N
    e[v] = 0
    visited = set()
    dfs(v, e, edges, visited)

    q = -1
    for i in range(N):
        if d[i] < e[i]:
            if e[i] > q:
                q = e[i]

    if q <= 0:
        print(0)
    else:
        print(q - 1)


def dfs(u: int, d: List[float], edges: List[List[int]], visited: set):
    visited.add(u)
    for nu in edges[u]:
        if nu not in visited and d[nu] == float('inf'):
            d[nu] = d[u] + 1
            dfs(nu, d, edges, visited)


if __name__ == "__main__":
    main()
