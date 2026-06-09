import sys

def main():
    # Read all input from standard input. Assuming space-separated values.
    try:
        # Read the entire line and split it into tokens
        data = sys.stdin.read().strip()
        if not data:
            return
        
        # Convert the first two tokens to integers
        x, t = map(int, data.split())
    except ValueError:
        # Handle cases where input is not two integers
        return

    # Calculate max(0, X - t)
    print(max(0, x - t))

if __name__ == "__main__":
    main()
