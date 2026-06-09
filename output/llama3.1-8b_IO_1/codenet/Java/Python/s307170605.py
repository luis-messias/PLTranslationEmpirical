import sys

def main():
    sc = sys.stdin
    for i in range(5):
        num = int(next(sc))
        if num == 0:
            print(i + 1)
            break

if __name__ == "__main__":
    main()
