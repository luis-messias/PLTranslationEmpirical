import sys

def solve():
    # Read inputs from standard input
    try:
        # Read pandu, vundu, urdu sequentially
        pandu = int(sys.stdin.readline())
        vundu = int(sys.stdin.readline())
        urdu = int(sys.stdin.readline())
    except:
        # Handle case where input might be missing or invalid, though usually guaranteed in CP context
        return

    # Calculate c = pandu * (1 + 2 + ... + urdu)
    # Sum of first N integers = N * (N + 1) / 2
    sum_series = urdu * (urdu + 1) // 2
    c = pandu * sum_series

    # Determine the output based on the comparison
    if c < vundu:
        print("0")
    else:
        print(c - vundu)

solve()