from collections import Counter
import sys

def solve():
    # Read the entire input line
    try:
        s = sys.stdin.read().strip()
    except Exception:
        s = ""

    if not s:
        # If input is empty, odd_count is 0.
        print("First")
        return

    # Count character frequencies
    char_counts = Counter(s)

    # Count how many characters appear an odd number of times
    odd_count = 0
    for count in char_counts.values():
        if count % 2 != 0:
            odd_count += 1

    # Apply the logic: First if oddCount <= 1 OR oddCount is odd
    if odd_count <= 1 or odd_count % 2 != 0:
        print("First")
    else:
        print("Second")

if __name__ == "__main__":
    solve()