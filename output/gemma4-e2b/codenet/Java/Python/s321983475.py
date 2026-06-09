import sys

def solve():
    # Read w, a, b from standard input
    try:
        w = int(sys.stdin.readline())
        a = int(sys.stdin.readline())
        b = int(sys.stdin.readline())
    except:
        # Handle case where input might be missing or invalid, though typically not needed in strict translation context
        return

    # Calculate the difference: max(a, b) - min(a, b) is the absolute difference |a - b|
    # The calculation is |a - b| - w
    answer = max(a, b) - min(a, b) - w
    
    if answer < 0:
        print(0)
    else:
        print(answer)

solve()