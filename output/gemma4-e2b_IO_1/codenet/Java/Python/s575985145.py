import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # data[0] is size
        size = int(data[0])
    except ValueError:
        return

    if size == 0:
        return

    # Initialize the graph matrix
    graph = [[0] * size for _ in range(size)]
    data_ptr = 1

    for _ in range(size):
        if data_ptr >= len(data):
            break
            
        try:
            # Read id (1-based index for the row)
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
            if 1 <= id <= size:
                graph[id - 1] = row
            
        except (IndexError, ValueError):
            # Stop if input format is broken or data runs out
            break

    # Output the graph
    for i in range(size):
        output_row = []
        for j in range(size):
            output_row.append(str(graph[i][j]))
        print(" ".join(output_row))

solve()
