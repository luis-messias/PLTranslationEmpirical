import sys
from collections import Counter

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # N is the first element
    try:
        N = int(input_data[0])
    except ValueError:
        return

    # The remaining elements are the numbers
    if N == 0:
        print(0)
        return

    try:
        numbers = [int(x) for x in input_data[1:N+1]]
    except IndexError:
        # Should not happen if input format is guaranteed, but safe check
        return

    # 1. Count frequencies
    counts = Counter(numbers)

    # 2. Modify frequencies and count two/one
    two = 0
