import sys

def main():
    scanner = sys.stdin
    h = int(next(scanner).split()[0])
    a = int(next(scanner).split()[0])
    if h % a == 0:
        print(h // a)
    else:
        print((h + a - 1) // a)

if __name__ == "__main__":
    main()
