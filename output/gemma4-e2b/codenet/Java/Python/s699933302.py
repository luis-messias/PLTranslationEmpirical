import sys

def main():
    # Read a, b, c from standard input
    try:
        # Read the three integers, assuming they are provided on separate lines or tokens
        a = int(sys.stdin.readline())
        b = int(sys.stdin.readline())
        c = int(sys.stdin.readline())
    except:
        # Handle potential EOF or invalid input if necessary, though usually omitted in direct translation context
        return

    count = 0
    # Iterate from a to b (inclusive)
    for i in range(a, b + 1):
        if c % i == 0:
            count += 1

    print(count)

if __name__ == "__main__":
    main()