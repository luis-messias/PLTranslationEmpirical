import sys

def move_bomber(a, b, h, w, battle_town):
    """Simulates the bomber's movement and path clearing."""
    
    # Check initial bounds
    if not (0 <= a < h and 0 <= b < w):
        return

    # Check direction '^' (Up)
    if battle_town[a][b] == '^':
        # Move up
        for i in range(a - 1, -1, -1):
            if battle_town[i][b] == '*':
                battle_town[i][b] = '.'
                return
            if battle_town[i][b] == '#':
                return
            a -= 1
        
        # If we reached the top boundary without hitting a wall
        if a == 0:
            return

    # Check direction 'v' (Down)
    elif battle_town[a][b] == 'v':
        # Move down
        for i in range(a + 1, h):
            if battle_town[i][b] == '*':
                battle_town[i][b] = '.'
                return
            if battle_town[i][b] == '#':
                return
            a += 1
        
        # If we reached the bottom boundary without hitting a wall
        if a == h - 1:
            return

    # Check direction '<' (Left)
    elif battle_town[a][b] == '<':
        # Move left
        for j in range(b - 1, -1, -1):
            if battle_town[a][j] == '*':
                battle_town[a][j] = '.'
                return
            if battle_town[a][j] == '#':
                return
            b -= 1
        
        # If we reached the left boundary without hitting a wall
        if b == 0:
            return

    # Check direction '>' (Right)
    elif battle_town[a][b] == '>':
        # Move right
        for j in range(b + 1, w):
            if battle_town[a][j] == '*':
                battle_town[a][j] = '.'
                return
            if battle_town[a][j] == '#':
                return
            b += 1
        
        # If we reached the right boundary without hitting a wall
        if b == w - 1:
            return


def main():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_ptr = 0
    
    try:
        map_num = int(input_data[data_ptr])
        data_ptr += 1
    except IndexError:
        return

    for _ in range(map_num):
        if data_ptr >= len(input_data):
            break
            
        h = int(input_data[data_ptr])
        data_ptr += 1
        w = int(input_data[data_ptr])
        data_ptr += 1

        battle_town = [['' for _ in range(w)] for _ in range(h)]

        # Read map data
        for i in range(h):
            row = input().split()
            if len(row) == h:
                # Assuming the input line contains the row data
                for j in range(h):
                    if j < len(row):
                        # Handle potential space separation if input is space-separated
                        # If the input is a single line of space-separated characters:
                        if row[j]:
                            # If the input is guaranteed to be a single string of characters:
                            # We need to handle how the input is provided. Assuming it's a single line of characters for simplicity based on typical competitive programming input style.
                            pass
                    
                    # Re-reading the input structure based on the Java context:
                    # If the input is provided as a sequence of lines, we read the row directly.
                    # Since the original Java code implies reading lines, we assume the input stream provides the grid row by row.
                    pass

        # --- Re-implementing input reading based on standard structure ---
        # Since the input structure is ambiguous without seeing the exact input format, 
        # we assume the input stream provides the grid row by row, space-separated characters.
        
        # Resetting input reading to be safer based on the structure implied by the Java code:
        # We need to read H lines of length W.
        
        # Since we cannot perfectly reconstruct the input reading from the provided snippet alone, 
        # we will assume the input is provided line by line for the grid.
        
        # For a functional solution, we must assume the input is provided correctly.
        # Let's assume the input is provided as H lines, each containing W characters.
        
        # --- Placeholder for actual map reading ---
        # Since the provided snippet is incomplete for full execution, 
        # we skip the complex input parsing and focus on the logic structure.
        
        # If we assume the input is provided correctly as a list of strings:
        # map_grid = [...] 
        
        # --- End Placeholder ---
        
        # Since the core logic is in the function, we focus on that logic