import sys

def main():
    try:
        # Read the input string C
        C = sys.stdin.read().strip()
    except:
        return

    if C:
        # Get the ASCII value of the first character, increment it, and convert back to a character
        print(chr(ord(C[0]) + 1))

if __name__ == "__main__":
    main()