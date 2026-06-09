import sys

def debug(*obj):
    # Mimicking Java's deepToString and printing to stderr
    print(str(obj), file=sys.stderr)

def solve():
    try:
        # Read N
        n = int(sys.stdin.readline())
    except:
        # Handle empty input case if necessary, though competitive programming assumes valid input
        return

    square = n * n
    odd = []
    even = []

    # Populate odd and even lists
    for i in range(1, square + 1):
        if i % 2 == 0:
            even.append(i)
        else:
            odd.append(i)

    # Calculate loop and div
    loop = square // n
    div = loop // 2

    debug(div)

    # Main loop structure
    for i in range(1, loop + 1):
        # Inner loop runs 'div' times
        for j in range(div):
            if i % 2 == 1:
                # i is odd: odd.pop(0) and even.pop()
                p1 = odd.pop(0)
                p2 = even.pop()
                print(f"{p1} {p2} ", end="")
            else:
                # i is even: even.pop(0) and odd.pop()
                p1 = even.pop(0)
                p2 = odd.pop()
                print(f"{p1} {p2} ", end="")
        
        # Print newline after the inner loop completes
        print()

if __name__ == "__main__":
    solve()