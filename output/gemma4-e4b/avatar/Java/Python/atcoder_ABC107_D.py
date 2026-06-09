import sys

def solve_task(arr):
    n = len(arr)
    sorted_arr = sorted(arr)
    
    # total = n * (n + 1) / 2
    total = n * (n + 1) // 2
    
    # Binary search range on sorted_arr indices
    l, r = 0, n - 1
    
    # BIT size needs to handle indices up to 2*n + 1. We use 1-based indexing.
    bit_size = 2 * n + 2
    
    def update_bit(bit, idx, val):
        # Updates the value at index idx (1-based)
        while idx < bit_size:
            bit[idx] += val
            idx += idx & (-idx)

    def query_bit(bit, idx):
        # Queries the prefix sum up to index idx (1-based)
        s = 0
        while idx > 0:
            s += bit[idx]
            idx -= idx & (-idx)
        return s

    while l <= r:
        mid = l + (r - l) // 2
        target = sorted_arr[mid]
        
        # Initialize BIT (1-based indexing, size 2n+2)
        bit = [0] * bit_size
        
        # Initialization step from Java code:
        # for ( int x = n + 1 ; x < bit.length ; x += x & -x ) bit [ x ] ++ ;
        # This loop updates all indices that are responsible for storing data in the BIT structure.
        x = n + 1
        while x < bit_size:
            update_bit(bit, x, 1)
            x += x & (-x)
        
        cur = 0
        cnt = 0
        
        for i in range(n):
            # Update cur
            if arr[i] <= target:
                cur += 1
            else:
                cur -= 1
            
            # Update BIT at cur + n + 1
            update_bit(bit, cur + n + 1, 1)
            
            # Query BIT up to cur + n
            # The query calculates the sum of counts for indices 1 to cur + n.
            cnt += query_bit(bit, cur + n)
        
        # Binary search logic
        if cnt >= total // 2 + 1:
            # Potential answer found, try smaller indices
            r = mid - 1
            result = target
        else:
            # Need larger indices
            l = mid + 1