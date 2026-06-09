import sys
from collections import Counter

def solve():
    # Read the input string from standard input
    try:
        s = sys.stdin.read().strip()
    except:
        s = ""

    if not s:
        print("No")
        return

    # Count character frequencies
    counts = Counter(s)

    # Check if the number of distinct characters is exactly 2
    if len(counts) == 2:
        # Check if all counts are exactly 2
        if all(count == 2 for count in counts.values()):
            print("Yes")
        else:
            print("No")
    else:
        print("No")

solve()