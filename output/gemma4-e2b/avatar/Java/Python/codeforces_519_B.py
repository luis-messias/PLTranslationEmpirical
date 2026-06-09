import sys

def solve():
    # Read all input tokens and split them into strings
    data = sys.stdin.read().split()
    
    if not data:
        return

    # Use an iterator to consume tokens sequentially
    it = iter(data)
    
    try:
        # Read N
        n = int(next(it))
    except StopIteration:
        return

    # Calculate A (sum of the next N numbers)
    a = 0
    for _ in range(n):
        try:
            a += int(next(it))
        except StopIteration:
            break

    # Calculate B (sum of the next N-1 numbers)
    b = 0
    for _ in range(n - 1):
        try:
            b += int(next(it))
        except StopIteration:
            break

    # Calculate C (sum of the next N-2 numbers)
    c = 0
    for _ in