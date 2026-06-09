import sys

def main():
    # Read X from the first line of input
    try:
        X = int(sys.stdin.readline())
    except:
        return

    # Read t from the second line of input
    try:
        t = int(sys.stdin.readline())
    except:
        return

    if X >= t:
        print(X - t)
    else:
        print(0)

if __name__ == "__main__":
    main()