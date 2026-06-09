import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    # Use an iterator for sequential reading
    data_iter = iter(data)

    try:
        # Read N and M
        N = int(next(data_iter))
        M = int(next(data_iter))
    except StopIteration:
        return

    # Initialize array a of size N with zeros
    a = [0] * N

    # Process M operations to build array a
    for i in range(M):
        # Read k
        try:
            k = int(next(data_iter))
        except StopIteration:
            return
        
        # Read k values of s
        for j in range(k):
            try:
                s = int(next(data_iter))
                s -= 1  # s-- in Java
                # a.set(s, a.get(s) | (1 << i))
                # Note: The Java code uses bitwise OR assignment for setting bits.
                # Since a[s] is initialized to 0, this effectively sets the bit if it wasn't already set.
                a[s] |= (1 << i)
            except StopIteration:
                return

    # Read M values to construct p
    p = 0
    for i in range(M):
        try:
            x = int(next(data_iter))
            # p |= (x << i)
            p |= (x << i)
        except StopIteration:
            return

    # Final counting loop
    ans = 0
    limit = 1 << N
    for s in range(limit):
        t = 0
        # Calculate XOR sum t
        for i in range(N):
            #