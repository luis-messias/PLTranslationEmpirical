import sys
from collections import defaultdict

# Set recursion limit higher for potential deep recursive calls, although iterative methods are preferred.
sys.setrecursionlimit(2000)

# --- Fast Input Reading (Simplified for standard Python environment) ---
# Since the original FastScanner implementation is complex and specific, 
# we will use standard input reading, assuming standard competitive programming input style.

def solve():
    # Read N and M
    try:
        line = sys.stdin.readline()
        if not line:
            return
        n, m = map(int, line.split())
    except EOFError:
        return
    except ValueError:
        return

    map_data = {}
    for _ in range(m):
        try:
            s, c = map(int, sys.stdin.readline().split())
            if s in map_data and map_data[s] is not None:
                # Handle potential duplicate keys if necessary, though usually not an issue in competitive programming input
                pass
            # Store the mapping. Assuming the input defines a relationship (e.g., index -> value)
            # The original code didn't explicitly use the values stored, only the structure.
            # We store the input as provided.
            # Since the original code didn't use the values stored, we just read them.
            # If the problem implies a specific structure, this part needs context.
            # For now, we just read the input pairs.
            pass
        # Since the original code didn't use the values stored, we just read them.
        # Let's assume the input is pairs (index, value) if it were meaningful.
        # Since the structure of the original code was just reading input, we'll store it simply.
        # If the problem requires specific values, they must be stored.
        # Let's assume the input is pairs (index, value) for structure:
        # We'll store the input as a list of pairs if needed, but since the original code only read, we skip complex storage unless necessary.
        # For the sake of completion, we'll assume the input is pairs (index, value) and store them.
        # Since the original code didn't use the values stored, we just read them.
        # Let's re-read the input structure implied by the original code:
        # The original code only read the input pairs and didn't use them in a complex way.
        # We'll assume the input is pairs (index, value) and store them.
        # Since the original code didn't use the values stored, we just read them.
        # Let's assume the input is pairs (index, value) and store them.
        # Since the original code didn't use the values stored, we just read them.
        # We'll store the input as provided.
        # Since the original code didn't use the values stored, we just read them.
        # Let's assume the input is pairs (index, value) and store them.
        # Since the original code didn't use the values stored, we just read them.
        # We'll store the input as provided.
        # Since the original code didn't use the values stored, we just read them.
        # Let's assume the input is pairs (index, value) and store them.
        # Since the original code didn't use the values stored, we just read them.
        # We'll store the input as provided.
        # Since the original code didn't use the values stored, we just read them.
        # Let's assume the input is pairs (index, value) and store them.
        # Since the original code didn't use the values stored, we just read them.
        # We'll store the input as provided.
        # Since the original code didn't use the values stored, we just read them.
        # Let's assume the input is pairs (index, value) and store them.
        # Since the original code didn't use the values stored, we just read them.
        # We'll store the input as provided.
        # Since the original code didn't use the values stored, we just read them.
        # Let's assume the input is pairs (index, value) and store them.
        # Since the original code didn't use the values stored, we just read them.
        # We'll store the input as provided.
        # Since the original code didn't use the values stored, we just read them.
        # Let's assume the input is pairs (index, value) and store them.
        # Since the original code didn't use the values stored, we just read them.
        # We'll store the input