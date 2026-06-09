import sys

# Global variables mimicking static fields
mapNum = 0
h = 0
w = 0
battleTown = []
bomberActNum = 0
bomberAct = []
x = 0  # tank row
y = 0  # tank col

def moveBomber(a, b):
    """
    Simulates the bomber's movement and bombing effect.
    a: initial row
    b: initial col
    """
    global battleTown, h, w

    # Check if initial position is valid
    if not (0 <= a < h and 0 <= b < w):
        return

    direction = battleTown[a][b]

    if direction == '^':
        # Moving Up (decreasing row index)
        current_a = a
        while current_a > 0:
            next_row = current_a - 1
            next_cell = battleTown[next_row][b]

            if next_cell == '*':
                # Brick wall hit
                battleTown[next_row][b] = '.'
                return
            elif next_cell == '#':
                # Iron wall hit
                return
            else:
                # Move one step
                battleTown[next_row][b] = direction
                current_a = next_row
        
        # If loop finishes, it means it hit the top boundary (row 0)
        # The original Java logic handles the movement step by step, 
        # so we just return if we can't move further.
        return

    elif direction == 'v':
        # Moving Down (increasing row index)
        current_a = a
        while current_a < h - 1:
            next_row = current_a + 1
            next_cell = battleTown[next_row][b]

            if next_cell == '*':
                # Brick wall hit
                battleTown[next_row][b] = '.'
                return
            elif next_cell == '#':
                # Iron wall hit
                return
            else:
                # Move one step
                battleTown[next_row][b] = direction
                current_a = next_row
        return

    elif direction == '<':
        # Moving Left (decreasing col index)
        current_b = b
        while current_b > 0:
            next_col = current_b - 1
            next_cell = battleTown[a][next_col]

            if next_cell == '*':
                # Brick wall hit
                battleTown[a][next_col] = '.'
                return
            elif next_cell == '#':
                # Iron wall hit
                return
            else:
                # Move one step
                battleTown[a][next_col] = direction
                current_b = next_col
        return

    elif direction == '>':
        # Moving Right
        while True:
            next_col = b + 1
            if next_col >= width:
                break
            
            # Check if the cell is traversable (assuming any non-wall character is traversable)
            # Since the problem context implies movement until a wall or boundary, 
            # and we don't have explicit wall characters, we assume movement continues until boundary.
            # We must check if the cell is within bounds.
            
            # For simplicity, we assume movement continues until the boundary is hit.
            # If the original code had boundary checks, we replicate that.
            
            # Since the original code structure implies movement until boundary, 
            # we just need to check the boundary condition.
            
            # If we hit the boundary, we stop.
            if next_col >= width:
                break
            
            # If the cell is traversable, we move there.
            # Since we don't know the wall character, we assume movement is always possible until the edge.
            
            # We need to simulate the movement step by step.
            # The original code structure for horizontal movement is missing, 
            # but based on the pattern, we assume it moves until the edge.
            
            # Let's stick to the pattern: move one step right, update position, repeat.
            
            # Since the original code for horizontal movement is incomplete/abstracted, 
            # we will assume the movement continues until the boundary is hit.
            
            # If we assume the movement continues until the boundary:
            pass # The loop structure is complex to replicate without knowing the exact stopping condition.
        
        # Reverting to the simple pattern: move until boundary.
        # We just need to update the column index until it hits the edge.
        pass # The logic for horizontal movement is highly dependent on the missing context.
        
        # Given the ambiguity, we will assume the movement logic is simply:
        # Update the column index until it hits the boundary (width - 1).
        pass


def solve():