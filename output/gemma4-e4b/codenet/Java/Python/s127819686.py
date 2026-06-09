import sys

def main():
    # Reading input from standard input
    try:
        # Read the first integer (a)
        a = int(sys.stdin.readline())
        # Read the second integer (b)
        b = int(sys.stdin.readline())
    except EOFError:
        # Handle case where input might be piped and ends unexpectedly
        return
    except ValueError:
        # Handle case where input might not be valid integers
        return

    # Calculate hb (integer division)
    hb = b // 2
    
    # Output the result
    print(a + hb)

if __name__ == "__main__":
    main()