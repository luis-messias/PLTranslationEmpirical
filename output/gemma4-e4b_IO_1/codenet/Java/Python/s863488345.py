import sys

# Global variables to simulate the state of the game board
# These will be initialized or modified by the main logic
battle_board = []
H = 0
W = 0

def initialize_board(board_data):
    """Initializes the global battle_board and dimensions."""
    global battle_board, H, W
    battle_board = board_data
    H = len(battle_board)
    W = len(battle_board[0]) if H > 0 else 0

def move_bomb(start_r, start_c, direction):
    """
    Simulates the movement of a bomb in a given direction.
    Returns the final (r, c) coordinates of the bomb.
    """
    r, c = start_r, start_c
    
    # Direction mapping: 0=Up, 1=Down, 2=Left, 3=Right
    dr = [(-1, 0), (1, 0), (0, -1), (0, 1)][direction]
    dc = [(-1, 0), (1, 0), (0, -1), (0, 1)][direction]
    
    # The bomb moves one step at a time until it hits a boundary or a wall ('#')
    while True:
        next_r = r + dr[0]
        next_c = c + dc[1]
        
        # Check boundaries
        if not (0 <= next_r < H and 0 <= next_c < W):
            break
        
        # Check for walls
        if battle_board[next_r][next_c] == '#':
            break
            
        # Move to the next valid spot
        r, c = next_r, next_c
        
    return r, c

def solve_game(board_data):
    """
    Main function to solve the bomb placement puzzle.
    Returns the list of coordinates for the bombs placed.
    """
    global battle_board, H, W
    initialize_board(board_data)
    
    bombs_placed = []
    
    # Iterate through the board to find the starting points of the bombs
    for r in range(H):
        for c in range(W):
            if battle_board[r][c] == 'B':
                # Found a bomb starting point
                start_r, start_c = r, c
                
                # Check all four directions (Up, Down, Left, Right)
                # Direction index: 0=Up, 1=Down, 2=Left, 3=Right
                for direction in range(4):
                    # Calculate the final position of the bomb in this direction
                    end_r, end_c = move_bomb(start_r, start_c, direction)
                    
                    # Store the coordinates of the bomb's end point
                    bombs_placed.append((end_r, end_c))
                    
    return bombs_placed

def print_result(bombs):
    """Prints the final result in the required format."""
    print("Bombs placed at:")
    for r, c in bombs:
        print(f"({r}, {c})")

# --- Example Usage ---

# Example 1: A simple 3x3 board
# B = Bomb start, # = Wall, . = Empty space
board_example_1 = [
    ['B', '.', '#'],
    ['.', '.', '.'],
    ['#', '.', 'B']
]

print("=========================================")
print("Solving Example 1:")
print("=========================================")
bombs_1 = solve_game(board_example_1)
print_result(bombs_1)

# Example 2: A larger board with more complex placement
board_example_2 = [
    ['B', '.', '.', '#', '.'],
    ['.', '.', '.', '.', '.'],
    ['#', '.', '.', '.', '#'],
    ['.', '.', '.', '.', '.'],
    ['.', '#', '.', '.', 'B']
]

print("\n\n=========================================")
print("Solving Example 2:")
print("=========================================")
bombs_2 = solve_game(board_example_2)
print_result(bombs_2)
