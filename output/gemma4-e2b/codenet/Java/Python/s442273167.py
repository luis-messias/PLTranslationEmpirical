import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        n = int(data[0])
    except ValueError:
        # Handle case where the first token is not an integer
        return

    if len(data) < 2 * n + 1:
        # Not enough data provided
        return

    # Extract l and r arrays
    # l starts at index 1 and goes for n elements
    l = [int(x) for x in data[1 : n + 1]]
    # r starts at index n + 1 and goes for n elements
    r = [int(x) for x in data[n + 1 : 2 * n + 1]]

    total_sum = 0
    for i in range(n):
        # Calculate r[i] - l[i] + 1 and add to sum
        total_sum += r[i] - l[i] + 1

    print(total_sum)

solve()