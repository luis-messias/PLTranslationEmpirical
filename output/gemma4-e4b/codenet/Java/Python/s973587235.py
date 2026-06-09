import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # n is the first element
    try:
        n = int(data[0])
    except IndexError:
        return

    # Check if enough data exists for initialization (at least n+1 elements needed)
    if len(data) < 2:
        # If n > 0 but only n is provided, we cannot initialize minN
        if n > 0:
            # Depending on expected behavior, we might assume failure or handle it gracefully.
            # Given the structure, we assume valid input sequence.
            pass
        return

    # minN is initialized using the second element (data[1])
    try:
        minN = int(data[1]) - 1
    except ValueError:
        return

    # h values start from index 2 up to index 2 + (n-1) - 1
    h_values = data[2:2 + (n - 1)]

    for h_str in h_values:
        try:
            h = int(h_str)
        except ValueError:
            # Skip or handle non-integer input if necessary
            continue

        # Logic translation
        if minN == h:
            minN = h
        elif minN == h - 1:
            minN = h - 1
        elif minN < h - 1:
            minN = h - 1
        elif minN > h:
            print("No")
            return

    print("Yes")

if __name__ == "__main__":
    solve()