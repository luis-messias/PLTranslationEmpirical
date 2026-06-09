import sys
import random
import io

# Set up input reading from stdin
# Reading all lines and splitting them is the most robust way to emulate the custom InputReader
def solve():
    # Read all input data
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_ptr = 0

    def next_int():
        nonlocal data_ptr
        if data_ptr >= len(input_data):
            raise EOFError("End of input")
        val = int(input_data[data_ptr])
        data_ptr += 1
        return val

    # --- Input Reading ---
    try:
        m = next_int()  # Number of manju
        n = next_int()  # Number of boxes
    except EOFError:
        return

    manju = [next_int() for _ in range(m)]
    
    boxlen = [0] * n
    boxcost = [0] * n
    
    for i in range(n):
        boxlen[i] = next_int()
        boxcost[i] = next_int()

    # --- Helper Functions ---

    # Equivalent to Java's sort method (shuffles and then sorts)
    def sort_array(a):
        # Since it ends with Arrays.sort(a), we just need to sort it.
        a.sort()

    # --- Main Logic ---
    
    sort_array(manju)

    # dp[i][j]: Max value considering manju starting from index i, and boxes from index j onwards.
    # Dimensions: (m+1) x (n+1)
    # Initialize with 0
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    # Iterate backwards
    for i