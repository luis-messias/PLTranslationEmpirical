import sys

def main():
    try:
        scanner = sys.stdin
        n = int(scanner.readline())
        numbers = set()
        for _ in range(n):
            numbers.add(int(scanner.readline()))
        print(len(numbers))
    except:
        pass

if __name__ == "__main__":
    main()
