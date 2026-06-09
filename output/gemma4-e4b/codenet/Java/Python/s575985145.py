import sys

def solve():
    # Read all input tokens into a list
    data = list(map(int, sys.stdin.read().split()))
    
    if not data:
        return

    data_ptr = 0
    
    # Read size
    size = data[data_ptr]
    data_ptr += 1
    
    # Initialize the graph (adjacency matrix)
    graph = [[0] * size for _ in range(size)]
    
    for _ in range(size):
        # Read id (1-based)
        id_node = data[data_ptr]
        data_ptr += 1
        
        # Read cols (number of neighbors)
        cols = data[data_ptr]
        data_ptr += 1
        
        # Initialize the row for the current node
        row = [0] * size
        
        # Read neighbors and set adjacency matrix entries
        for _ in range(cols):
            neighbor_id = data[data_ptr]
            data_ptr += 1
            
            # Neighbors are 1-based, indices are 0-based
            row[neighbor_id - 1] = 1
        
        # Store the row in the graph at the correct index (id_node - 1)
        graph[id_node - 1] = row
    
    # Print the resulting graph
    for row in graph:
        print(*(row))

solve()