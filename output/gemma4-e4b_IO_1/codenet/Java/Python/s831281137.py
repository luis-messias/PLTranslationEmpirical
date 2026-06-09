import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Helper index for reading tokens
    data_ptr = 0

    def read_int():
        nonlocal data_ptr
        if data_ptr < len(data):
            val = int(data[data_ptr])
            data_ptr += 1
            return val
        return None

    # Read N (number of items) and W (capacity)
    N = read_int()
    W = read_int()

    if N is None or W is None:
        return

    # v[i] = value of item i, w[i] = weight of item i
    # Using 1-based indexing conceptually, so size N+1
    v = [0] * (N + 1)
    w = [0] * (N + 1)

    # Read item values and weights
    for i in range(1, N + 1):
        v[i] = read_int()
        w[i] = read_int()

    # sumV[i][j] stores the maximum value using the first i items with capacity j
    # Size (N+1) x (W+1)
    sumV = [[0] * (W +
