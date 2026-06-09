import sys

def solve():
    # Initialize the 4x3x10 array with zeros
    info = [[[0 for _ in range(10)] for _ in range(3)] for _ in range(4)]

    # Read input from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # The first element is n
    n = int(input_data[0])
    
    # Process the remaining n * 4 elements
    data_index = 1
    for _ in range(n):
        if data_index + 3 >= len(input_data):
            break
            
        built = int(input_data[data_index])
        floor = int(input_data[data_index + 1])
        room = int(input_data[data_index + 2])
        num = int(input_data[data_index + 3])
        
        # Update the array (using 0-based indexing)
        info[built - 1][floor - 1][room - 1] += num
        
        data_index += 4

    # Output printing
    for i in range(4):
        for j in range(3):
            # Print 10 values for the current row (j)
            row_output = " ".join(map(str, info[i][j]))
            print(row_output)
        
        # Print separator line if it's not the last layer
        if i < 3:
            print("####################")

if __name__ == "__main__":
    solve()