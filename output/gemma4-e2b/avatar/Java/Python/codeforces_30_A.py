import sys

def solve():
    # Read input from stdin
    try:
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        A = int(data[0])
        B = int(data[1])
        n = int(data[2])
    except ValueError:
        return

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

    # Search for integer x such that x^n = B
    # The loop iterates x from 0 up to B (inclusive)
    for x in range(B + 1):
        if pow(x, n) == B:
            if neg:
                print(-x