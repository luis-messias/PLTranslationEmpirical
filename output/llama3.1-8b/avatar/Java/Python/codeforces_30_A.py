import math

def solve(sc):
    A = int(sc.next())
    B = int(sc.next())
    n = int(sc.next())

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
    sc = input()
    solve(sc)

if __name__ == "__main__":
    main()