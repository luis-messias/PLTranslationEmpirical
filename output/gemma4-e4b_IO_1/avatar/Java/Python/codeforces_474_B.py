import sys

def fun(arr, q_val, n, m):
    """
    Performs a binary search on arr to find the index related to q_val.
    This function replicates the logic of the original Java binary search,
    which finds the index of the first element >= q_val (or the insertion point).
    """
    res = 0
    i = 0
    # The array size is n, so the last valid index is n - 1.
    # We correct the upper bound j from the original Java code (j=n) to j=n-1.
    j = n - 1
    
    while i <= j:
        # Calculate middle index safely
        md = i + (j - i) // 2
        
        if arr[md] == q_val:
            return md
        elif arr[md] > q_val:
            # Potential insertion point (or index of first element >= q_val)
            res = md
            j = md - 1
        else: # arr[md] < q_val
            i = md + 1
            
    return res

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    data_ptr = 0

    # 1. Read N and calculate prefix sums (arr)
    try:
        n = int(data[data_ptr])
        data_ptr += 1
    except IndexError:
        return # Handle empty input case

    arr = []
    if n > 0:
        # Read the first element
        try:
            arr.append(int(data[data_ptr]))
            data_ptr += 1
        except IndexError:
            return

        # Calculate subsequent prefix sums
        for _ in range(1, n):
