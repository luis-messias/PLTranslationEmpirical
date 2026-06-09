import sys
from typing import List, Dict, Optional, Tuple

# Set recursion limit higher for safety in deep recursive calls
# sys.setrecursionlimit(2000) 

# --- Input Handling Simulation ---
# In a real competitive programming environment, reading input line by line 
# using sys.stdin.readline is the standard equivalent to Java's BufferedReader.

def input_reader() -> List[str]:
    """Reads all lines from standard input."""
    return sys.stdin.read().splitlines()

# --- Utility Classes Translation ---

class Pair:
    """Represents a pair of values (like Java's Pair)."""
    def __init__(self, first: any, second: any):
        self.first = first
        self.second = second

    def __repr__(self):
        return f"Pair({self.first}, {self.second})"

class Graph:
    """
    A simple adjacency list representation for a graph.
    Assumes unweighted edges for simplicity, but can be adapted for weights.
    """
    def __init__(self, num_nodes: int):
        # Adjacency list: {node: [(neighbor, weight), ...]}
        self.adj: Dict[int, List[Tuple[int, float]]] = {i: [] for i in range(num_nodes)}
        self.num_nodes = num_nodes

    def add_edge(self, u: int, v: int, weight: float = 1.0):
        """Adds an undirected edge between u and v with a given weight."""
        self.adj[u].append((v, weight))
        self.adj[v].append((u, weight))

    def get_neighbors(self, node: int) -> List[Tuple[int, float]]:
        """Returns neighbors and weights for a given node."""
        return self.adj.get(node, [])

# --- Core Logic/Algorithm Placeholders ---
# The original Java code snippet was incomplete regarding the main logic 
# (e.g., Dijkstra's, BFS, etc.). I've kept the structure but added 
# a placeholder for a common algorithm like Dijkstra's to show usage.

def dijkstra(graph: Graph, start_node: int) -> Dict[int, float]:
    """
    Placeholder implementation for Dijkstra's algorithm.
    Returns the shortest distance from start_node to all other nodes.
    """
    import heapq
    
    distances: Dict[int, float] = {i: float('inf') for i in range(graph.num_nodes)}
    distances[start_node] = 0.0
    
    # Priority queue stores (distance, node)
    pq: List[Tuple[float, int]] = [(0.0, start_node)]
    
    while pq:
        dist, u = heapq.heappop(pq)
        
        if dist > distances[u]:
            continue
            
        for v, weight in graph.get_neighbors(u):
            new_dist = dist + weight
            if new_dist < distances[v]:
                distances[v] = new_dist
                heapq.heappush(pq, (new_dist, v))
                
    return distances

# --- Main Execution Block ---

def solve():
    """
    Main function to simulate the execution flow.
    Reads input and calls the appropriate logic functions.
    """
    print("--- Starting Solver Simulation ---", file=sys.stderr)
    
    # 1. Input Reading Simulation
    input_lines = input_reader()
    if not input_lines:
        print("No input provided. Exiting.", file=sys.stderr)
        return

    # Example: Assuming the first line contains N (number of nodes)
    try:
        N = int(input_lines[0].strip())
        print(f"Successfully read N = {N} from input.", file=sys.stderr)
    except ValueError:
        print("Could not parse N from the first line. Check input format.", file=sys.stderr)
        return

    # 2. Graph Initialization and Population (Simulation)
    graph = Graph(N)
    
    # Simulate reading edges from the next lines (e.g., N-1 lines)
    # Format expected: u v weight
    print("Simulating edge reading...", file=sys.stderr)
    
    # Example: Manually adding a few edges for testing the Dijkstra placeholder
    if N >= 4:
        graph.add_edge(0, 1, 1.0)
        graph.add_edge(0, 2, 5.0)
        graph.add_edge(1, 2, 2.0)
        graph.add_edge(2, 3, 1.0)
        
    # 3. Algorithm Execution (Simulation)
    start_node = 0
    print(f"Running Dijkstra's algorithm from node {start_node}...", file=sys.stderr)
    shortest_paths = dijkstra(graph, start_node)
    
    # 4. Output Results
    print("\n--- Results ---", file=sys.stderr)
    print(f"Shortest paths from node {start_node}:", file=sys.stderr)
    for node, dist in shortest_paths.items():
        print(f"To node {node}: {dist:.2f}", file=sys.stderr)

if __name__ == "__main__":
    # To run this simulation, you must pipe input into the script, 
    # e.g., `echo "4" | python your_script_name.py`
    solve()