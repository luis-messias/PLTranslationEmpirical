import sys

def solve():
    # Read the single line of input
    try:
        # Read the line and strip potential trailing newline/whitespace
        line = sys.stdin.readline().strip()
    except:
        # Handle potential empty input if necessary
        return

    if line:
        # Replace commas with spaces
        result = line.replace(",", " ")
        # Print the result
        print(result)

solve()