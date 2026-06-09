import sys

def solve():
    try:
        # Read the single line of input
        line = sys.stdin.read().strip()
        if not line:
            # Handle empty input case if necessary, though problem context implies input exists
            print("NO")
            return

        # Split and convert to integers
        parts = line.split()
        if len(parts) < 3:
            # Handle insufficient input
            print("NO")
            return

        x = int(parts[0])
        a = int(parts[1])
        y = int(parts[2])

    except Exception:
        # Handle parsing errors
        print("NO")
        return

    h = "NO"

    # Check the combined condition: (x=5 or x=7 or a=5 or a=7 or y=5 or y=7)
    if (x == 5 or x == 7 or a == 5 or a == 7 or y == 5 or y == 7):
        # If the first condition is met, check the sum
        if (x + y + a == 17):
            h = "YES"

    print(h)

if __name__ == "__main__":
    solve()