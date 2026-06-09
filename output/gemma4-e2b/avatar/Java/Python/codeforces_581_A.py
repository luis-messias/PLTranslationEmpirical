import sys

def solve():
    # Read a and b from standard input
    try:
        # Read the line and split into two integers
        line = sys.stdin.read().split()
        if len(line) < 2:
            return
        a = int(line[0])
        b = int(line[1])
    except:
        # Handle potential empty input or formatting errors gracefully
        return

    count = 0
    # The loop runs as long as both a and b are positive
    while a > 0 and b > 0:
        count += 1
        a -= 1
        b -= 1

    # Calculate the result using the final values of a and b
    # Python's division operator (/) results in a float, matching the Java behavior.
    ans = a / 2 + b / 2

    # Print the result
    print(count, ans)

solve()