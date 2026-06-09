import sys

def main():
    # Read the entire line of input from standard input
    try:
        # Reading input using sys.stdin.read().strip() is robust for single-line execution
        input_line = sys.stdin.read().strip()
        
        if not input_line:
            return

        # Split the line and convert the first two parts to integers
        parts = input_line.split()
        
        if len(parts) < 2:
            return

        a = int(parts[0])
        b = int(parts[1])

        # Apply the logic
        if b % a == 0:
            print(a + b)
        else:
            print(b - a)

    except ValueError:
        # Handles cases where input parts are not valid integers
        pass

if __name__ == "__main__":
    main()