import sys

def solve():
    try:
        # Read the single long integer input
        n = int(sys.stdin.read().strip())
    except:
        # Handle case where no input is provided
        return

    # Calculate n * (n + 1) / 2 - n
    # Using integer division (//) since the result must be an integer
    result = n * (n + 1) // 2 - n
    print(result)

solve()