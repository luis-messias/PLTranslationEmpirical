import sys

def solve():
    # Read input from stdin
    try:
        # Read numNode and numEdge
        line = sys.stdin.readline()
        if not line:
            return
        numNode, numEdge = map(int, line.split())
    except EOFError:
        return
    except ValueError:
        # Handle case where input might be empty or malformed initially
        return

    # Initialize adjacency list
    connect = [[] for _ in range(numNode)]

    # Read edges
    for _ in range(numEdge):
        try:
            u, v = map(int, sys.stdin.readline().split())
            # Convert to 0-indexed
            a = u - 1
            b = v - 1
            connect[a].append(b)
            connect[b].append(a)
        except:
            # Handle potential reading errors if input ends prematurely
            continue

    # Check if numEdge is odd
    if numEdge % 2 != 0:
        print(-1)
        return

    # Initialize state variables
    visited = [0] * numNode  # 0: unvisited, 1: visiting, 2: visited/finished
    odd = [False] * numNode
    print_lines = []

    # DFS function definition (using nested function or passing state)
    def dfs(crt, parent):
        visited[crt] = 1
        crt_connect = connect[crt]

        for child in crt_connect:
            if child == parent or visited[child] == 1:
                continue
            
            if visited[child] == 2:
                # Case 1: Back edge to a finished node (visited[child] == 2)
                # This branch seems to handle printing an edge and flipping parity for crt
                print_lines.append(f"{crt + 1} {child + 1}\n")
                odd[crt] = not odd[crt]
            else:
                # Case 2: Tree edge (child is unvisited)
                dfs(child, crt)
                
                # Post-recursion logic based on child's parity
                if odd[child]:
                    # If child has odd parity, print edge and flip parity for child
                    print_lines.append(f"{child + 1} {crt + 1}\n")
                    odd[child] = not odd[child]
                else:
                    # If child has even parity, print edge and flip parity for crt
                    print_lines.append(f"{crt + 1} {child + 1}\n")
                    odd[crt] = not odd[crt]

        # Mark current node as finished
        visited[crt] = 2

    # Start DFS from node 0 (arbitrary start)
    dfs(0, -1)

    # Print results
    print("".join(print_lines))

solve()