import sys

def main():
    i = 1
    scanner = iter(sys.stdin)
    while True:
        try:
            n = next(scanner).strip()
            if n == '0':
                break
            else:
                i += 1
        except StopIteration:
            print(i)

if __name__ == "__main__":
    main()
