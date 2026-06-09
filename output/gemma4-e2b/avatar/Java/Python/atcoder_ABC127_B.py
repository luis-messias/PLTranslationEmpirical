import sys

def solve():
    # Read all input from stdin and split into tokens
    data = sys.stdin.read().split()
    
    if len(data) < 3:
        return

    try:
        # Read r, d, and x
        r = int(data[0])
        d = int(data[1])
        x = int(data[2])
    except ValueError:
        # Handle potential conversion errors if input is not numeric
        return

    # Perform the calculation 10 times
    for _ in range(10):
        x = r * x - d
        print(x)

if __name__ == "__main__":
    solve()