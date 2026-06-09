import sys

def solve():
    # Read all input from stdin and split it into tokens
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        # r and d are integers
        r = int(data[0])
        d = int(data[1])
        
        # x is the initial long integer
        x = int(data[2])
    except Exception:
        # Handle case where input might be malformed or missing
        return

    # Loop 10 times, calculating x = r * x - d
    for _ in range(10):
        x = r * x - d
        print(x)

if __name__ == "__main__":
    solve()