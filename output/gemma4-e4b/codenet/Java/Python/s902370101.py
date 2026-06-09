import sys

def solve():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first element is N
        n = int(data[0])
    except ValueError:
        return

    # The next N elements are the array values
    if len(data) < n + 1:
        # Not enough data provided
        return

    # Extract the array elements
    array = [int(x) for x in data[1:n+1]]

    if not array:
        # If n=0, the Java code initializes max=0, min=10000, and prints -10000.
        # If we assume standard constraints where n >= 1, this block is skipped.
        # If we must replicate the n=0 behavior:
        if n == 0:
            print(0 - 10000)
        return

    # Calculate max and min using Python built-ins
    max_val = max(array)
    min_val = min(array)
    
    print(max_val - min_val)

if __name__ == "__main__":
    solve()