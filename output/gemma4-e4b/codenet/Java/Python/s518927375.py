import sys

def solve():
    # Read all three values from standard input. Assuming they are space-separated.
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        k = int(data[0])
        a = int(data[1])
        b = int(data[2])
    except EOFError:
        return
    except IndexError:
        # Handle case where not enough inputs are provided
        return

    if b <= a + 2:
        print(1 + k)
        return

    x = k - (a - 1)
    # Python's // operator performs floor division, matching Java's integer division.
    ans = a + (x // 2) * (b - a) + (x % 2)

    print(ans)

solve()