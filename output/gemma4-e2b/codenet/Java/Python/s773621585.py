import sys

def main():
    # Read N
    try:
        # Read the first line which should be the integer N
        n_line = sys.stdin.readline()
        if not n_line:
            return
        n = int(n_line.strip())
    except ValueError:
        return

    # Initialize the map
    map_data = {}

    # Read N subsequent lines and populate the map
    for _ in range(n):
        # Read the next line for the key
        line = sys.stdin.readline().strip()
        if line:
            map_data[line] = ""

    # Print the size of the map
    print(len(map_data))

if __name__ == "__main__":
    main()