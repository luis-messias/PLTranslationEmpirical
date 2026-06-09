import sys

def main():
    # Read all four integers from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])
        d = int(data[3])
    except Exception:
        # Handle case where input might be missing or malformed
        return

    # The logic compares a*b and c*d and prints the larger one.
    if a * b >= c * d:
        print(a * b)
    elif a * b <= c * d:
        print(c * d)

if __name__ == "__main__":
    main()