import sys

def main():
    # Read all inputs from standard input
    # Assuming the input format is two integers on separate lines or space-separated
    try:
        # Read the first integer (X)
        x = int(sys.stdin.readline().strip())
        # Read the second integer (t)
        t = int(sys.stdin.readline().strip())
    except EOFError:
        # Handle case where input might be empty
        return
    except ValueError:
        # Handle case where input might not be integers
        return

    if x - t >= 0:
        print(x - t)
    else:
        print(0)

if __name__ == "__main__":
    main()