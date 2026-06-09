import sys

def main():
    # Read all input lines
    lines = sys.stdin.read().splitlines()
    
    if not lines:
        return

    try:
        # Read N from the first line
        n = int(lines[0])
    except ValueError:
        return

    if n == 1:
        print("Hello World")
    else:
        # If N != 1, we expect two more numbers on the next two lines
        if len(lines) >= 3:
            try:
                # Read the two numbers
                a = int(lines[1])
                b = int(lines[2])
                print(a + b)
            except ValueError:
                # Handle case where subsequent lines are not integers
                pass

if __name__ == "__main__":
    main()