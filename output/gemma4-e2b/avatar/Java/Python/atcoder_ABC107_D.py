import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # arr contains the N elements
    arr = [int(x) for x in data[1:N+1]]

    # --- Start of Task.solve logic ---
    
    # 1. Copy and sort the array
    sorted_arr = sorted(arr)
    
    # Calculate total sum of 1 to N
    total = N * (N + 1) // 2
    
    l = 0
    r = N - 1
    
    # Binary search for the result
    while l < r:
        mid = l + (r - l) // 2
        target = sorted_arr[mid]
        
        # --- Logic to calculate count (using BIT structure) ---
        
        # Initialize BIT structure (size 2*N + 2)
        # In Python, we use a list initialized to zeros.
        bit_size = 2 * N + 2
        bit = [0] * bit_size
        
        # Initialize BIT structure (equivalent to Java initialization loop)
        # This loop initializes the BIT structure for indices starting from N+1
        # x += x & -x is the standard way to iterate over indices in a BIT structure
        for x in range(N + 1, bit_size):
            # This part seems to be initializing the structure for indices > N
            # In the Java code: for ( int x = n + 1 ; x < bit.length ; x += x & - x ) bit [ x ] ++ ;
            # This looks like a specific initialization pattern for a BIT structure, 
            # often used for range updates or specific indexing.
            # Since the subsequent logic depends on this initialization, we replicate it.
            bit[x] += 1 

        cur = 0
        cnt = 0
        
        # Process elements relative to target
        for i in range(N):
            # Calculate cur: count of elements <= target
            cur += 1 if arr[i] <= target else -1
            
            # Update BIT based on cur
            # In the Java code: for ( int x = cur + n + 1 ; x < bit.length ; x += x & - x ) bit [ x ] ++ ;
            # Note: The Java code uses bit[x]++ where x is derived from cur.
            # We must ensure indices are within