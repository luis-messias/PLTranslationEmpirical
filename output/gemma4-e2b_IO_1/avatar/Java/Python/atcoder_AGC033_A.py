import sys
from collections import deque

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # H and W are the first two integers
    try:
        H = int(input_data[0])
        W = int(input_data[1])
    except IndexError:
        return

    # Reconstruct the grid A
    A = []
    data_index = 2
    
    for i in range(H):
        if data_index < len(input_data):
            row_str = input_data[data_index]
            data_index += 1
            # Ensure the row length matches W, although in this specific problem context, 
            # the input format usually provides exactly W characters per row.
            A.append(list(row_str))
        else:
            # Handle unexpected end of input if necessary
            break

    # Initialize queue for BFS
    queue = deque()
    
    # Find starting points ('#') and initialize BFS
    for r in range(H):
        for c in range(W):
            if A[r][c] == '#':
                # Store (row, col, depth)
                queue.append((r, c, 0))

    # Flag array to track visited cells (0: unvisited, 1: visited)
    flag = [[0] * W for _ in range(H)]
    
    # Directions: (dr, dc) for down, up, right, left
    dr = [1, -1, 0, 0]
    dc = [0, 0, 1, -1]
    
    # BFS loop
    while queue:
        r, c, depth = queue.popleft()
        
        # Explore neighbors
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            
            # Boundary check
            if 0 <= nr < H and 0 <= nc < W:
                # Check if unvisited and target cell ('.')
                if flag[nr][nc] == 0 and A[nr][nc] == '.':
                    # Found the shortest path
                    print(depth + 1)
                    return
                
                # If unvisited, mark as visited and add to queue
                if flag[nr][nc] == 0:
                    flag[nr][nc] = 1
                    queue.append((nr, nc, depth + 1))

solve()
