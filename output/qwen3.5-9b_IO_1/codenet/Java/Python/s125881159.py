import sys

def main():
    input = sys.stdin.read
    data = input().split()
    n = int(data[0])
    d = 0
    for i in range(1, n + 1):
        d += int(data[i]) % 2
    print("YES" if d % 2 == 0 else "NO")

if __name__ == "__main__":
    main()
