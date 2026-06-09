import sys
import io

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

    # Equivalent to Java's sort method (Arrays.sort(a))
    def sort_array(a):
        a.sort()

    # --- Main Logic ---
    
    sort_array(manju)

    # dp[i][j]: Max value considering manju starting from index i, and boxes from index j onwards.
    # Dimensions: (m+1) x (n+1)
    # Initialize with 0
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    # Iterate backwards
    for i in range(m - 1, -1, -1):
        for j in range(n - 1, -1, -1):
            
            # Option 2: Skip box j
            dp[i][j] = dp[i][j+1]
            
            # Option 1: Use box j
            
            # Calculate effective length (len)
            len_manju_covered = boxlen[j]
            
            # The number of manju items available to cover is m - i.
            # The actual length covered is min(boxlen[j], m - i).
            # The Java logic calculates: int len=i+boxlen[j]>=m?m:i+boxlen[j];
            # This 'len' seems to be the index *after* the last manju used, 
            # relative to the start of the array (index 0).
            
            len_dp = min(i + boxlen[j], m)
            
            # Calculate sum of manju values (cnt)
            # The manju used are those corresponding to indices k from i to len_dp - 1.
            # The Java code uses manju[m-1-k].
            # k=i -> manju[m-1-i]
            # k=len_dp-1 -> manju[m-1-(len_dp-1)]
            
            cnt = 0
            for k in range(i, len_dp):
                # Index used in Java: m - 1 - k
                cnt += manju[m - 1 - k]
            
            # Calculate potential new max value
            # dp[len_dp][j+1] + cnt - boxcost[j]
            new_val = dp[len_dp][j+1] + cnt - boxcost[j]
            
            # Update dp[i][j]
            dp[i][j] = max(dp[i][j], new_val)

    print(dp[0][0])

solve()
