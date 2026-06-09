import sys

MOD = 998244353

def main():
    n = int(input())
    ai = []
    bi = []

    for _ in range(n):
        a, b = map(int, input().split())
        ai.append(a)
        bi.append(b)

    ai.sort()
    bi.sort()

    if n % 2 == 1:
        print(bi[n // 2] - ai[n // 2] + 1)
    else:
        b = (ai[n // 2] + ai[n // 2 - 1]) / 2
        c = (bi[n // 2] + bi[n // 2 - 1]) / 2
        print(int(2 * (c - b) + 1))

if __name__ == "__main__":
    main()