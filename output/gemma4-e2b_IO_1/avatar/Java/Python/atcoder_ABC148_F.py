import sys
from collections import defaultdict

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The input format seems to be: N, u, v, followed by 2*(N-1) edge endpoints
    
    # Read N, u, v
    N = int(input_data[0])
    u = int(input_data[1]) - 1  # 0-indexed
    v = int(input_data[2]) - 1  # 0-indexed
    
    # Read edges
    edges_data = input_data[3:]
    
    # Build adjacency list
    edges = defaultdict(list)
    
    # Edges are provided in pairs (a, b)
    for i in range(0, len(edges_data), 2):
        if i + 1 < len(edges_data):
            a = int(edges_data[i]) - 1
            b = int(edges_data[i+1]) - 1
            edges[a].append(b)
            edges[b].append(a)

    # DFS function to calculate distances
    def dfs(start_node, distances, adj):
        # Initialize distances to infinity (equivalent to Integer.MAX_VALUE)
        for i in range(N):
            distances[i] = float('inf')
        
        distances[start_node] = 0
        
        stack = [start_node]
