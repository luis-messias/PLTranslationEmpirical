import sys

def main():
    # Read the input string (equivalent to sc.next())
    try:
        s = sys.stdin.readline().strip()
    except EOFError:
        return

    if not s:
        return

    # Extract the last character and convert it to an integer
    # s[-1] gets the last character
    try:
        n = int(s[-1])
    except ValueError:
        # Handle case where the last character is not a digit
        return

    if n == 3:
        print("bon")
    elif n == 0 or n == 1 or n == 6 or n == 8:
        print("pon")
    else:
        print("hon")

if __name__ == "__main__":
    main()