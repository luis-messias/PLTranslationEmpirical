import collections
import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_ptr = 0
    
    # Read N
    try:
        n = int(input_data[data_ptr])
        data_ptr += 1
    except IndexError:
        return

    # Initialize adjacency matrix g (size n+1 x n+1 for 1-based indexing)
    g = [[0] * (n + 1) for _ in range(n + 1)]
    
    # Read edges
    # The loop runs n times (corresponding to the n blocks of edges)
    for _ in range(n):
        if data_ptr >= len(input_data):
            break
            
        try:
            u = int(input_data[data_ptr])
            data_ptr += 1
            
            k = int(input_data[data_ptr])
            data_ptr += 1
        except IndexError:
            break

        # Read k neighbors v
        for _ in range(k):
            if data_ptr >= len(input_data):
                break
            try:
                v = int(input_data[data_ptr])
                data_ptr += 1
                
                # Set edge g[u][v] = 1
                g[u][v] = 1
            except ValueError:
                # Should not happen if input is well-formed
                break
            
    # BFS setup
    # d[i] stores the distance from node 1 to node i
    d = [-1] * (n + 1)
    que = collections.deque()
    
    # Start BFS from node 1
    start_node = 1
    que.append(start_node)
    d[start_node] = 0
    
    # BFS execution
    while que:
        top = que.popleft()
        
        # Iterate through all possible neighbors j (1 to n)
        for j in range(1, n + 1):
            # Check if edge exists AND if unvisited
            if g[top][j] == 1 and d[j] == -1:
                que.append(j)
                d[j] = d[top] + 1
                
    # Output results
    for i in range(1, n + 1):
        print(f"{i} {d[i]}")

if __name__ == "__main__":
    solve()