import sys

def main():
    try:
        # Read the integer input from standard input
        x = int(sys.stdin.read().strip())
    except EOFError:
        # Handle case where no input is provided
        return
    except ValueError:
        # Handle case where input is not a valid integer
        return

    # Calculate the answer
    ans = (2199 - x) // 200
    
    # Print the result
    print(ans)

if __name__ == "__main__":
    main()