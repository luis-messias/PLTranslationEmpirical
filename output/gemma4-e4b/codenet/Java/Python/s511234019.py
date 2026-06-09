import sys

def main():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if len(data) < 2:
        return

    try:
        a = int(data[0])
        b = int(data[1])
    except ValueError:
        return

    if a % 2 == 0 or b % 2 == 0:
        print("No")
    else:
        print("Yes")

if __name__ == "__main__":
    main()