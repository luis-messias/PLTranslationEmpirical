import sys

def solve():
    # Read all input data
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_index = 0
    
    # numNode = sc.nextInt()
    num_node = int(input_data[data_index])
    data_index += 1
    
    # numEdge = sc.nextInt()
    num_edge = int(input_data[data_index])
    data_index += 1

    # Initialize adjacency list (connect)
    connect = [[] for _ in range(num_node)]
    
    # Read edges
    for _ in range(num_edge):
        # a = sc.nextInt() - 1
        a = int(input_data[data_index]) - 1
        data_index += 1
        # b = sc.nextInt() - 1
        b = int(input_data[data_index]) - 1
        data_index += 1
        
        connect[a].append(b)
        connect[b].append(a)

    # Check parity condition
    if num_edge % 2 != 0:
        print(-1)
        return

    # Global state variables (mimicking static Java variables)
    visited = [0] * num_node  # 0: unvisited, 1: visiting, 2: finished
    odd_parity = [False] * num_node
    print_output = []

    # DFS function definition
    def dfs(crt, parent):
        # visited[crt] = 1
        visited[crt] = 1
        
        crt_connect = connect[crt]
        
        for child in crt_connect:
            if child == parent or visited[child] == 1:
                continue
            
            if visited[child] == 2:
                # Child subtree already processed
                print_output.append(f"{crt + 1} {child + 1}")
                odd_parity[crt] = not odd_parity[crt]
            else:
                # Unvisited child
                dfs(child, crt)
                
                # After returning from DFS(child, crt)
                if odd_parity[child]:
                    # Child subtree resulted in odd parity
                    print_output.append(f"{child + 1} {crt + 1}")
                    odd_parity[child] = not odd_parity[child]
                else:
                    # Child subtree resulted in even parity
                    print_output.append(f"{crt + 1} {child + 1}")
                    odd_parity[crt] = not odd_parity[crt]
        
        # visited[crt] = 2
        visited[crt] = 2

    # Start DFS from node 0
    dfs(0, -1)
    
    # Print the accumulated output
    print('\n'.join(print_output))

solve()