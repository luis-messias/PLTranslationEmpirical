import sys

def solve():
    # Read all three inputs from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return

        pandu = int(data[0])
        vundu = int(data[1])
        urdu = int(data[2])
    except Exception:
        return

    # Calculate c = pandu * (1 + 2 + ... + urdu)
    # Using the arithmetic series sum formula: Sum(1 to N) = N * (N + 1) / 2
    # Python handles large integers automatically.
    c = pandu * (urdu * (urdu + 1) // 2)

    if c < vundu:
        print("0")
    else:
        print(c - vundu)

if __name__ == "__main__":
    solve()