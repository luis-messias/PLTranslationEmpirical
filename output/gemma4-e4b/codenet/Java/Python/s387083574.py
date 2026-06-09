import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first token is N
    try:
        N = int(input_data[0])
    except ValueError:
        # Handle case where N is not an integer
        return

    # The next N tokens are the values
    if len(input_data) < N + 1:
        # Not enough input values provided
        return

    values = [int(x) for x in input_data[1:N+1]]

    # Create the map (dictionary): key is index (1 to N), value is the read input
    data_map = {}
    for i in range(N):
        # Key is i + 1 because indexing starts at 1
        data_map[i + 1] = values[i]

    # Sort the items (key, value) based on the value (item[1])
    # sorted_items will be a list of tuples: [(key1, value1), (key2, value2), ...]
    sorted_items = sorted(data_map.items(), key=lambda item: item[1])

    # Extract the keys (item[0]) in the sorted order
    sorted_keys = [str(item[0]) for item in sorted_items]

    # Join the keys into a space-separated string and print
    print(" ".join(sorted_keys))

if __name__ == "__main__":
    solve()