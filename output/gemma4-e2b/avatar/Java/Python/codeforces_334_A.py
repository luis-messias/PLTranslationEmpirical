import sys

def debug(obj):
    print(repr(obj), file=sys.stderr)

def main():
    try:
        # Read input n
        n = int(sys.stdin.readline())
    except:
        # Handle case where input might be empty or invalid, although typically competitive programming inputs are guaranteed.
        return

    square = n * n
    odd = []
    even = []

    # Populate odd and even lists up to square
    for i in range(1, square + 1):
        if i % 2 == 0:
            even.append(i)
        else:
            odd.append(i)

    loop = square // n  # loop = n
    div = loop // 2     # div = n // 2

    debug(div)

    # Main printing loop
    for i in range(1, loop + 1):
        for j in range