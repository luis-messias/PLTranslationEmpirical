import sys

def main():
    # Read A
    try:
        A = int(sys.stdin.readline())
    except:
        return

    # Read B
    try:
        B = int(sys.stdin.readline())
    except:
        return

    # Read T
    try:
        T = int(sys.stdin.readline())
    except:
        return

    # Calculate (T / A) * B. In Java, integer division is used for int types.
    # T / A in Java (where T and A are ints) performs integer division.
    result = (T // A) * B

    # Print the result (equivalent to the log method)
    print(result)

if __name__ == "__main__":
    main()