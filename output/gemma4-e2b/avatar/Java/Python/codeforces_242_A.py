import sys

def solve():
    # Read all four integers from standard input
    try:
        data = sys.stdin.read().split()
        if len(data) < 4:
            return
        x = int(data[0])
        y = int(data[1])
        a = int(data[2])
        b = int(data[3])
    except:
        # Handle case where input might be empty or malformed
        return

    count = 0
    # Calculate count: pairs (i, j) such that a <= i <= x, b <= j <= y, and i > j
    for i in range(a, x + 1):
        for j in range(b, y + 1):
            if i > j:
                count += 1

    print(count)

    # Print the pairs (i, j) such that a <= i <= x, b <= j <= y, and i > j
    for i in range(a, x + 1):
        for j in range(b, y + 1):
            if i > j:
                print(f"{i} {j}")

solve()