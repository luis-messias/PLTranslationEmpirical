import math

def solve(sc):
    A = int(next(sc))
    B = int(next(sc))
    n = int(next(sc))

    if A == 0:
        if B == 0:
            print(1)
        else:
            print("No solution")
        return

    if B % A != 0:
        print("No solution")
        return

    B //= A
    neg = B < 0
    if neg and n % 2 == 0:
        print("No solution")
        return

    if neg:
        B = -B

    for x in range(B + 1):
        if math.pow(x, n) == B:
            print(neg and -x or x)
            return

    print("No solution")

def main():
    with open('input.txt', 'r') as f:
        sc = iter(f.read().split())
    solve(sc)

if __name__ == "__main__":
    main()
