import sys

def fun(arr, q, n, m):
    """
    Performs a binary search on arr to find the index related to q.
    The original Java implementation uses a search range [0, n] which is unsafe.
    We adjust the upper bound to n-1 (the last valid index) while preserving the logic.
    """
    res = 0
    i = 0
    j = n - 1  # Corrected upper bound for array of size n
    
    while i <= j:
        # Calculate middle index safely
        md = i + (j - i) // 2
        
        if arr[md] == q:
            return md
        elif arr[md] > q:
            # Potential insertion point (or index of first element >= q)
            res = md
            j = md - 1
        else: # arr[md] < q
            i = md + 1
            
    return res

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    if not data:
        return

    data_ptr = 0

    # 1. Read N and calculate prefix sums (arr)
    n = int(data[data_ptr])
    data_ptr += 1
    
    arr = []
    if n > 0:
        # Read the first element
        arr.append(int(data[data_ptr]))
        data_ptr += 1
        
        # Calculate subsequent prefix sums
        for _ in range(1, n):
            x = int(data[data_ptr])
            data_ptr += 1
            arr.append(x + arr[-1])

    # 2. Read M
    m = int(data[data_ptr