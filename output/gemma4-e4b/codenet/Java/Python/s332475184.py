import sys
from collections import defaultdict

# Set up input reading from stdin
def solve():
    # Read all tokens from standard input
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_ptr = 0

    def next_int():
        nonlocal data_ptr
        if data_ptr < len(input_data):
            val = int(input_data[data_ptr])
            data_ptr += 1
            return val
        raise EOFError("End of input reached")

    # 1. Read N and Q
    try:
        N = next_int()
        Q = next_int()
    except EOFError:
        return

    # 2. Initialize graph and counter
    graph = defaultdict(list)
    counter = [0] * N

    # 3. Read N-1 edges
    for _ in range(N - 1):
        try:
            a = next_int() - 1
            b = next_int() - 1
            graph[a].append(b)
            graph[b].append(a)
        except EOFError:
            # Handle case where input might terminate early
            break

    # 4. Read Q queries
    for _ in range(Q):
        try:
            u = next_int() - 1
            val = next_int()
            counter[u] += val
        except EOFError:
            break

    # 5. DFS traversal
    # The DFS function needs to be defined to use the global/enclosing scope variables (graph, counter)
    
    def dfs(v, parent, path_val):
        # path_val is the accumulated sum from root to parent(v)
        
        # Recurse on children
        for neighbor in graph[v]:
            if neighbor != parent:
                # The value passed down is the current path_val plus the value accumulated at v
                dfs(neighbor, v, path_val + counter[v])
        
        # Post-order update: Update counter[v] by adding the path_val received from its parent
        counter[v] += path_val

    # Start DFS from node 0. Parent is -1 (or any invalid node). Initial path_val is 0.
    dfs(0, -1, 0)

    # 6. Output results
    print(*(counter))

solve()