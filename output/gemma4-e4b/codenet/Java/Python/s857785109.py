import sys

def main():
    try:
        # Read the integer input
        n = int(sys.stdin.read().strip())
    except:
        # Handle empty input case if necessary, though usually not required for direct translation
        return

    # Check the conditions: (n/10) % 111 == 0 OR (n % 1000) % 111 == 0
    # In Python, integer division is done using //
    if ((n // 10) % 111 == 0) or ((n % 1000) % 111 == 0):
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()