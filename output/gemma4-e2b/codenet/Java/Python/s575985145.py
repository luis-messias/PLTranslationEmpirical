import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        size = int(data[0])
    except ValueError:
        # Handle case where the first token is not an integer
        return

    # Initialize the graph matrix
    graph = [[0] * size for _ in range(size)]
    data_ptr = 1

    for _ in range(size):
        if data_ptr >= len(data):
            break
            
        try:
            # Read id (1-based index)
            id = int(data[data_ptr])
            data_ptr += 1
            
            # Read cols (number of connections)
            cols = int(data[data_ptr])
            data_ptr += 1
            
            # Read cols indices
            row = [0] * size
            for _ in range(cols):
                if data_ptr >= len(data):
                    break
                index = int(data[data_ptr])
                # Java uses 1-based index, so subtract 1 for 0-based indexing
                if 1 <= index <= size:
                    row[index - 1] = 1
                data_ptr += 1
            
            # Store the row. id is 1-based, so use id - 1
            if