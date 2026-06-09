import sys

def main():
    # Read three integers from standard input
    try:
        # Read all three integers from a single line or three separate lines
        # Assuming standard competitive programming input style where inputs are provided sequentially
        x = int(sys.stdin.readline())
        y = int(sys.stdin.readline())
        z = int(sys.stdin.readline())
    except EOFError:
        # Handle case where input might be piped or ends unexpectedly
        return
    except ValueError:
        # Handle case where input is not an integer
        return

    # The Java code reads three integers and then prints them in the order z, x, y.
    print(f"{z} {x} {y}")

if __name__ == "__main__":
    main()