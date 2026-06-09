import sys

def main():
    # Read all space-separated integers from standard input
    try:
        # Read all available input and split by whitespace
        data = sys.stdin.read().split()
        
        if len(data) < 3:
            return

        # Input order: x, y, z
        x = int(data[0])
        y = int(data[1])
        z = int(data[2])

        # Output order: z, x, y
        print(f"{z} {x} {y}")

    except Exception:
        # Handle potential reading or conversion errors
        pass

if __name__ == "__main__":
    main()
