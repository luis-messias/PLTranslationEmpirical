import sys

def rec(x):
    """Counts the number of set bits (1s) in the binary representation of x."""
    count = 0
    # Mimicking the Java loop: checking bits 31 down to 0
    for k in range(31, -1, -1):
        if (x >> k) & 1:
            count += 1
    return count

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    n = int(data[0])
    
    # The subsequent elements are the numbers x_i
    input_numbers = [int(x) for x in data[1:]]
    
    # Array a, indexed by bit count (max 32 bits, so size 33 is safe)
    # Initialize with zeros. Index corresponds to the bit count.
    a = [0] * 33
    
    # Process the N input numbers
    for i in range(n):
        # The input number x is the (i+1)-th number