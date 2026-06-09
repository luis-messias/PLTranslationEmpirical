import sys
import io

# Set up input reading from stdin
input_data = sys.stdin.read().split()
if not input_data:
    # Handle case where input is empty
    exit()

# Use an iterator for reading input tokens
data_iter = iter(input_data)

def read_int():
    return int(next(data_iter))

# Read N
try:
    n = read_int()
except StopIteration:
    # Should not happen if input is well-formed
    exit()

# Initialize graph G (Adjacency List)
# G will store lists of Edge objects or tuples representing neighbors and edge IDs
g = [[] for _ in range(n)]

# Read N-1 edges and build the graph
for i in range(n - 1):
    try:
        # a and b are 1-based in input, convert to 0-based indices
        a = read_int() - 1
        b = read_int() - 1
    except StopIteration:
        # Ran out of input unexpectedly
        break

    # The Java code adds edges (i, b) and (i, a) where i is the edge index (0 to n-2)
    # This suggests the edge index i corresponds to the edge being added.
    # The edge IDs in the Java code seem to be 0 to n-2.
    
    # We store the edge information along with the destination node and the edge ID
    # Since the Java code uses Edge objects with an 'id', we need to track edge IDs explicitly.
    
    # Let's adjust the graph structure to store (neighbor, edge_id)
    # The Java code uses Edge(i, b) and Edge(i, a) where i is the edge index (0 to n-2).
    
    # We need to store the edge ID associated with the connection.
    # Since the DFS relies on ans[e.id], we must ensure e.id corresponds to the edge index.
    
    # Let's redefine G to store (neighbor, edge_index)
    
    # Re-reading the Java logic:
    # g.get(a).add(new Edge(i, b)); g.get(b).add(new Edge(i, a));
    # i here is the index of the edge being processed (0 to n-2).
    
    # We will store tuples (neighbor, edge_index) in the adjacency list.
    
    # Edge index for this edge is i
    g[a].append((b, i))
    g[b].append((a, i))


# Initialize ans array for n-1 edges
ans = [0] * (n - 1)

# DFS function implementation
# to: current node
# color: the 'color' parameter from the Java code (used for comparison)
# parents: parent node
def dfs(to, color, parents):
    # k tracks the assigned value (1-based)
    k = 1
    
    # Iterate over neighbors (neighbor, edge_id)
    for neighbor, edge_id in g[to]:
        if neighbor == parents:
            continue
        
        # Check the condition: if k == color, increment k
        if k == color:
            k += 1
            
        # Assign the result to ans[edge_id]
        # Note: The Java code assigns ans[e.id] = k. e.id is the edge index.
        ans[edge_id] = k
        
        # Recursive call
        dfs(neighbor, k, to)
        
        # Increment k after the recursive call returns (this corresponds to the Java k++)
        k += 1

# Start DFS from node 0, initial color/value is -1 (or whatever the Java code implies)
# The Java call was dfs(0, -1, -1)
dfs(0, -1, -1)

# Find max
max_val = 0
if ans:
    max_val = max(ans)

# Print results
print(max_val)
for result in ans:
    print(result)