from collections import Counter
import sys

def solve():
    # Read the input string (assuming it's a single token/word)
    try:
        s = sys.stdin.read().strip()
    except EOFError:
        s = ""

    if not s:
        print("No")
        return

    # Count character frequencies
    counts = Counter(s)

    # Condition 1: All characters must appear exactly twice
    all_counts_are_two = all(count == 2 for count in counts.values())

    # Condition 2: There must be exactly two distinct characters
    num_distinct_chars = len(counts)

    if all_counts_are_two and num_distinct_chars == 2:
        print("Yes")
    else:
        print("No")

solve()