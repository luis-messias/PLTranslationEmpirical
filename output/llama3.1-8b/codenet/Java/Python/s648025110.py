import sys

def main():
    n = int(input())
    h = [int(input()) for _ in range(n)]

    ans, out = 0, 0

    for i in range(n):
        if out < h[i]:
            ans += h[i] - out
            out = h[i]
        else:
            out = h[i]

    print(ans)

if __name__ == "__main__":
    main()