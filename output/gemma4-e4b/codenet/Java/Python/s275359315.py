import sys

def main():
    # Read the integer input from standard input
    try:
        # Reading all input and stripping whitespace is robust for single integer input
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        r = int(input_data)
    except ValueError:
        # Handle case where input is not a valid integer
        return

    # Calculate r squared
    res = r * r
    
    # Print the result
    print(res)

if __name__ == "__main__":
    main()