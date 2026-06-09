import sys

def solve():
    # Read all input tokens from stdin, mimicking Scanner's sequential reading
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first element is N
        N = int(data[0])
    except ValueError:
        return

    # The data points are the elements from index 1 up to index N (inclusive).
    # Total elements processed: N+1 (N itself + N data points).
    data_points = data[1:N+1]
    
    if not data_points:
        return

    # Initialize max and min with the first data point
    try:
        max_val = min_val = int(data_points[0])
    except ValueError:
        return

    # Iterate over the remaining N data points (N-1 iterations)
    for i in range(1, len(data_points)):
        try:
            in_val = int(data_points[i])
            max_val = max(max_val, in_val)
            min_val = min(min_val, in_val)
        except ValueError:
            # Stop if non-integer data is encountered
            break

    print(max_val - min_val)

if __name__ == "__main__":
    solve()
