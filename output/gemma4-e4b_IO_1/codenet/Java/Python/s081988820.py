import collections

class Solution:
    def solve(self, grid: list[list[int]], n: int) -> int:
        """
        Calculates the number of connected components of '1's in the grid, 
        considering only the top-left n x n subgrid.
        """
        if not grid or not grid[0]:
            return 0

        # The problem statement implies we only care about the top-left n x n subgrid
        # We will use the full grid dimensions for safety, but only process up to n.
        rows = len(grid)
        cols = len(grid[0])
        
        # The effective boundary for processing is min(rows, n) and min(cols, n)
        effective_rows = min(rows, n)
        effective_cols = min(cols, n)

        visited = [[False for _ in range(effective_cols)] for _ in range(effective_rows)]
        component_count = 0

        def dfs(r, c):
            """Performs Depth First Search to find all connected '1's."""
            if r < 0 or r >= effective_rows or \
               c < 0 or c >= effective_cols or \
               visited[r][c] or \
               grid[r][c] != 1:
                return
            
            visited[r][c] = True
            
            # Check 4 directions: up, down, left, right
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        # Iterate only over the top-left n x n area
        for r in range(effective_rows):
            for c in range(effective_cols):
                if grid[r][c] == 1 and not visited[r][c]:
                    # Found the start of a new connected component
                    component_count += 1
                    dfs(r, c)
        
        return component_count

# Example Usage based on the problem context (assuming the provided structure)
# The input format suggests a grid and an integer 'n'.

# Example 1: A simple case
grid1 = [
    [1, 1, 0],
    [1, 0, 0],
    [0, 0, 0]
]
n1 = 2
# Expected: The 1s at (0,0), (0,1), (1,0) form one component.
solver = Solution()
result1 = solver.solve(grid1, n1)
# print(f"Result 1: {result1}") # Expected: 1

# Example 2: Two separate components in the top-left 3x3
grid2 = [
    [1, 0, 1],
    [0, 0, 0],
    [1, 0, 1]
]
n2 = 3
# Expected: (0,0) is one, (0,2) is another, (2,0) is another, (2,2) is another. Total 4.
result2 = solver.solve(grid2, n2)
# print(f"Result 2: {result2}") # Expected: 4

# Example 3: Larger grid, small n
grid3 = [
    [1, 1, 1, 1],
    [1, 0, 0, 1],
    [1, 0, 0, 1],
    [1, 1, 1, 1]
]
n3 = 2
# Top-left 2x2:
# 1 1
# 1 0
# One component.
result3 = solver.solve(grid3, n3)
# print(f"Result 3: {result3}") # Expected: 1

# Example 4: n larger than grid size
grid4 = [
    [1, 1],
    [1, 1]
]
n4 = 5
# Processes the whole 2x2 grid. One component.
result4 = solver.solve(grid4, n4)
# print(f"Result 4: {result4}") # Expected: 1

# The provided test case structure suggests the function signature might be different, 
# but based on the logic derived from the problem description (connected components in top-left n x n), 
# the implemented method should be correct.
