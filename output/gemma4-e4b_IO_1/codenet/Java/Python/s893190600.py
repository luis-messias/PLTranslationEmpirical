import collections
from typing import List, Dict, Tuple

# Helper class to represent the graph structure (Adjacency List)
class Graph:
    def __init__(self, num_nodes: int):
        # graph[u] = list of (v, weight)
        self.adj: Dict[int, List[Tuple[int, float]]] = collections.defaultdict(list)
        self.num_nodes = num_nodes

    def add_edge(self, u: int, v: int, weight: float):
        # Assuming undirected graph for simplicity, adjust if directed
        self.adj[u].append((v, weight))
        self.adj[v].append((u, weight))

# Dijkstra's Algorithm implementation
def dijkstra(graph: Graph, start_node: int) -> Dict[int, float]:
    """
    Calculates the shortest path from start_node to all other nodes.
    Returns a dictionary mapping node ID to shortest distance.
    """
    # Initialize distances: infinity for all nodes except start_node (0)
    distances: Dict[int, float] = {node: float('inf') for node in range(graph.num_nodes)}
    distances[start_node] = 0.0

    # Priority Queue: stores (distance, node)
    # We use a min-heap structure (Python's heapq)
    import heapq
    pq: List[Tuple[float, int]] = [(0.0, start_node)]

    while pq:
        # Get the node with the smallest current distance
        current_distance, current_node = heapq.heappop(pq)

        # If we found a shorter path already, skip this outdated entry
        if current_distance > distances[current_node]:
            continue

        # Explore neighbors
        for neighbor, weight in graph.adj[current_node]:
            # Calculate the new distance to the neighbor through the current node
            new_distance = current_distance + weight

            # Relaxation step: If a shorter path is found, update distance and push to PQ
            if new_distance < distances[neighbor]:
                distances[neighbor] = new_distance
                heapq.heappush(pq, (new_distance, neighbor))

    return distances

# --- Main Logic Simulation ---

def solve_shortest_path_problem(num_nodes: int, edges: List[Tuple[int, int, float]], start_node: int) -> Dict[int, float]:
    """
    Initializes the graph and runs Dijkstra's algorithm.
    
    Args:
        num_nodes: Total number of nodes (0 to num_nodes-1).
        edges: List of (u, v, weight) tuples representing edges.
        start_node: The source node for the shortest path calculation.
        
    Returns:
        A dictionary containing the shortest distance from start_node to all reachable nodes.
    """
    if num_nodes <= 0:
        return {}
        
    graph = Graph(num_nodes)
    
    for u, v, weight in edges:
        # Ensure nodes are within the valid range [0, num_nodes - 1]
        if 0 <= u < num_nodes and 0 <= v < num_nodes:
            graph.add_edge(u, v, weight)
        else:
            print(f"Warning: Edge ({u}, {v}) contains nodes outside the valid range [0, {num_nodes-1}]. Skipping.")

    print(f"Graph initialized with {graph.num_nodes} nodes.")
    
    # Run Dijkstra's algorithm
    shortest_distances = dijkstra(graph, start_node)
    
    return shortest_distances

# --- Example Usage ---
if __name__ == "__main__":
    # Example 1: Standard Graph Example
    print("=====================================================")
    print("Running Example 1: Standard Weighted Graph")
    
    NUM_NODES_1 = 5  # Nodes 0, 1, 2, 3, 4
    START_NODE_1 = 0
    
    # Edges: (u, v, weight)
    EDGES_1 = [
        (0, 1, 10.0),
        (0, 3, 5.0),
        (1, 2, 2.0),
        (2, 3, 1.0),
        (3, 4, 3.0)
    ]
    
    results_1 = solve_shortest_path_problem(NUM_NODES_1, EDGES_1, START_NODE_1)
    
    print(f"\nShortest distances from Node {START_NODE_1}:")
    for node, dist in results_1.items():
        if dist == float('inf'):
            print(f"  Node {node}: Unreachable")
        else:
            print(f"  Node {node}: {dist:.1f}")

    # Expected shortest paths from 0:
    # 0 -> 0: 0.0
    # 0 -> 1: 10.0 (Direct)
    # 0 -> 2: 12.0 (0->3->2: 5+1+2=8? Wait, 0->3->2 is 5+1=6. Let's check the graph structure)
    # 0 -> 3: 5.0
    # 0 -> 4: 8.0 (0->3->4: 5+3=8)
    
    # Re-checking 0->2: 0->3 (5) -> 2 (1). Total = 6.0.
    # The implementation should yield 6.0 for Node 2.
    
    print("\n=====================================================")
    print("Running Example 2: Disconnected Graph")
    
    NUM_NODES_2 = 6 # Nodes 0, 1, 2, 3, 4, 5
    START_NODE_2 = 0
    
    # Nodes 0, 1, 2 are connected. Nodes 3, 4, 5 are separate.
    EDGES_2 = [
        (0, 1, 1.0),
        (1, 2, 1.0)
    ]
    
    results_2 = solve_shortest_path_problem(NUM_NODES_2, EDGES_2, START_NODE_2)
    
    print(f"\nShortest distances from Node {START_NODE_2}:")
    for node, dist in results_2.items():
        if dist == float('inf'):
            print(f"  Node {node}: Unreachable")
        else:
            print(f"  Node {node}: {dist:.1f}")
