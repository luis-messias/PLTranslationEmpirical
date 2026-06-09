BASE = 3

def main():
    try:
        # Read integer input from standard input
        x = int(input())
        # Calculate x raised to the power of BASE
        result = x ** BASE
        print(result)
    except EOFError:
        # Handles cases where no input is provided
        pass
    except ValueError:
        # Handles cases where input is not a valid integer
        pass

if __name__ == "__main__":
    main()