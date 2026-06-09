import sys

def main():
    # Read all input from stdin and split into tokens
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        E = int(data[0])
        Y = int(data[1])
    except IndexError:
        # Handle case where input might be missing
        return

    if E == 0:
        if Y <= 1911:
            print("M", end="")
            print(Y - 1867)
        elif Y <= 1925:
            print("T", end="")
            print(Y - 1911)
        elif Y <= 1988:
            print("S", end="")
            print(Y - 1925)
        else:
            print("H", end="")
            print(Y - 1988)
    elif E == 1:
        print(1867 + Y)
    elif E == 2:
        print(1911 + Y)
    elif E == 3:
        print(1925 + Y)
    else:
        print(1988 + Y)

if __name__ == "__main__":
    main()