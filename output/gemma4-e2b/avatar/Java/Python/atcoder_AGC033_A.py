import sys
from collections import deque

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # H and W are the first two integers
    H = int(input_data[0])
    W = int(input_data[1])
    
    # The grid starts from index 2 in input_data
    grid_data = input_data[2:]
    
    # Reconstruct the grid A
    A = []
    data_index = 0
    for i in range(H):
        row = []
        for j in range(W):
            if data_index < len(grid_data):
                row.append(grid_data[data_index])
                data_index += 1
            else:
                # Handle case where input might be truncated, though unlikely in competitive programming context
                pass
        A.append(row)

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
    
    # Directions: (dr, dc) for up, down, right, left
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    ans = -1 # Initialize answer to an invalid state

    while queue:
        r, c, depth = queue.popleft()
        
        # Check if the current cell is a target ('.')
        # Note: The Java code checks neighbors for '.' cells. We check the current cell here 
        # if we are looking for the shortest path from '#' to '.', but the Java logic focuses on neighbors.
        # Let's stick to the Java logic: check neighbors.

        for i in range(4):
            nr, nc = r + dy[i], c + dx[i]
            
            # Boundary check
            if 0 <= nr < H and 0 <= nc < W:
                # Check if unvisited and target cell ('.')
                if flag[nr][nc] == 0 and A[nr][nc] == '.':
                    flag[nr][nc] = 1
                    ans = depth + 1
                    # Since BFS finds the shortest path first, we can stop immediately
                    print(ans)
                    return
                
                # If unvisited, add to queue for further exploration
                if flag[nr][nc] == 0:
                    # We