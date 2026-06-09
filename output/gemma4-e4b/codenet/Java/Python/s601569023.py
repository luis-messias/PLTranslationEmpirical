import sys

def main():
    try:
        # Read the integer input from standard input
        num = int(sys.stdin.read().strip())
    except EOFError:
        # Handle case where no input is provided (though usually not necessary for simple competitive programming style)
        return
    except ValueError:
        # Handle case where input is not a valid integer
        return

    if num < 1200:
        print("ABC")
    else:
        print("ARC")

if __name__ == "__main__":
    main()