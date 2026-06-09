import sys

def main():
    input_data = iter(sys.stdin.read().strip())
    n = next(input_data)
    d=0
    for _ in range(n):
        x = int(next(input_data)) % 2
        d += x
    print("YES" if d % 2 == 0 else "NO")

if __name__ == "__main__":
    main()