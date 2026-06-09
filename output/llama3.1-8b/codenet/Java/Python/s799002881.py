import sys

def main():
    n, d = map(float, input().split())
    cnt = 0

    for _ in range(int(n)):
        x, y = map(float, input().split())
        if (x**2 + y**2) ** 0.5 <= d:
            cnt += 1

    print(cnt)

if __name__ == "__main__":
    main()