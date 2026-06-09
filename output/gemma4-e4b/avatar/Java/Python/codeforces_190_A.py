import sys

def solve():
    # Read all input data and split it into tokens
    data = sys.stdin.read().split()
    if not data:
        return

    try:
        n = int(data[0])
        m = int(data[1])
    except IndexError:
        # Handle case where not enough input is provided
        return

    if n == 0:
        if m != 0:
            print("Impossible")
        else:
            # Equivalent to Java's System.out.println("0 0")
            print("0 0")
        return

    if m <= n:
        if m == 0:
            m = 1
        # Output: n and (m + n - 1)
        print(f"{n} {m + n - 1}")
        return

    # Case m > n
    # Output: m and (m + n - 1)
    print(f"{m} {m + n - 1}")

if __name__ == "__main__":
    solve()