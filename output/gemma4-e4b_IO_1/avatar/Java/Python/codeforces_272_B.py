import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # N is the first element
    try:
        n = int(input_data[0])
    except IndexError:
        return

    # The numbers to process are the next N elements
    numbers = []
    for i in range(1, n + 1):
        try:
            numbers.append(int(input_data[i]))
        except IndexError:
            # Handle case where input might be truncated
            break

    # Function to count set bits (population count)
    def rec(x):
        return bin(x).count('1')

    # Array to store counts. Max popcount is 32 (for 2^32 - 1). Size 3
