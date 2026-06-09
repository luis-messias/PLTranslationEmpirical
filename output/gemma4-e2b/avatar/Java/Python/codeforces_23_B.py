import sys

def maxLeft(n):
    return n - 2 if n > 2 else 0

def main():
    # Read all input from stdin and split into tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is t
    try:
        t = int(data[0])
    except ValueError:
        return

    # Iterate through the remaining elements, which are the values of n
    # Start reading n from index 1
    for i in range(1, len(data)):
        try:
            n = int(data[i])
            print(maxLeft(n))
        except ValueError:
            # Skip if conversion fails
            continue

if __name__ == "__main__":
    main()