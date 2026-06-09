import sys
import math

def combinations(m, n):
    """Calculates C(m, n) = m choose n."""
    if n < 0 or n > m:
        return 0
    return math.comb(m, n)

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # N and P are the first two elements
    N = int(input_data[0])
    P = int(input_data[1])
    
    # The remaining elements are the sequence of numbers
    data_sequence = [int(x) for x in input_data[2:]]

    k0 = 0  # Count of even numbers
    k1 = 0  # Count of odd numbers

    for x in data_sequence:
        if x % 2 == 0:
            k0 += 1
        else:
            k1 += 1

    # Calculate ans = 2^k0
    ans = 2**k0

    # Calculate the sum B
    add = 0

    if P == 0:
        # Sum for i = 0, 2, 4, ..., <= k1
        i = 0
        while i <= k1:
            add += combinations(k1, i)
            i += 2
    else:
        # Sum for i = 1, 3, 5, ..., <= k1
        i = 1
        while i <= k1:
            add += combinations(k1, i)
            i += 2

    # Final result
    result = ans * add
    print(result)

if __name__ == "__main__":
    solve()