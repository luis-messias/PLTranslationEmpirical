import sys

INF = 10**9 + 5
scanner = sys.stdin.readline

def main():
    n = int(scanner())
    a = []
    b = []

    for _ in range(n):
        line = scanner().split()
        a.append(int(line[0]))
        b.append(int(line[1]))

    left, right = INF, 0
    for i in range(n):
        left = min(left, a[i])
        right = max(right, b[i])

    for i in range(n):
        if left == a[i] and right == b[i]:
            print(i + 1)
            return

    print(-1)

if __name__ == "__main__":
    main()
