import sys

def solve(n):
    return (n // 3) * 2 + (0 if n % 3 == 0 else 1)

def main():
    n = int(sys.stdin.readline())
    solve(n)

if __name__ == "__main__":
    main()