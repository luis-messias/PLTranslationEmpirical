import sys
import io
import math

# Set recursion limit higher for safety, although not strictly necessary here
# sys.setrecursionlimit(2000)

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # The input sequence is: a, b, q, s1, s2, ..., sa, t1, t2, ..., tb, x1, x2, ..., xq

    try:
        # Parse a, b, q
        a = int(input_data[0])
        b = int(input_data[1])
        q = int(input_data[2])

        # Parse arrays s and t
        s = [0] * (a + 2)
        t = [0] * (b + 2)

        # Read s (a elements)
        for i in range(a):
            s[i + 1] = int(input_data[3 + i])

        # Read t (b elements)
        for i in range(b):
            t[i + 1] = int(input_data[3 + a + i])

        # Initialize boundaries
        s[0] = t[0] = -10_000_000_000
        s[a + 1] = t[b + 1] = 20_000_000_000

        # Process queries
        output = []
        for i in range(q):
            x = int(input_data[3 + a + b + i])

            # Helper function equivalent to ArrayUtil.lowerBound(a, t, min)
            def lower_bound(arr, target):
                # Finds the index of the first element >= target
                min_idx = 0
                max_idx = len(arr)
                while min_idx < max_idx:
                    mid = (min_idx + max_idx) // 2
                    if target <= arr[mid]:
                        max_idx = mid
                    else:
                        min_idx = mid + 1
                return min_idx

            # Calculate indices using the logic from Java:
            # ArrayUtil.lowerBound(s, x + 1) - 1
            # ArrayUtil.lowerBound(t, x + 1) - 1
            # ArrayUtil.lowerBound(s, x)
            # ArrayUtil.lowerBound(t, x)

            # Note: The Java implementation uses ArrayUtil.lowerBound(array, x + 1) - 1
            # This seems to find the index of the element just before the first element >= x+1.
            # If we use the standard lower_bound definition (first element >= t), we need to adjust.

            # Let's replicate the Java logic exactly:
            # Java: s[Math.max(0, ArrayUtil.lowerBound(s, x + 1) - 1)]
            
            # We need a robust lower_bound implementation that handles array bounds correctly.
            
            # Re-implementing lowerBound based on the Java logic structure:
            def array_util_lowerBound(arr, t):
                # Finds the index of the first element >= t
                min_idx = 0
                max_idx = len(arr)
                while min_idx < max_idx:
                    mid = (min_idx + max_idx) // 2
                    if t <= arr[mid]:
                        max_idx = mid
                    else:
                        min_idx = mid + 1
                return min_idx

            # Calculate indices based on the Java formula:
            
            # Index for s: Math.max(0, ArrayUtil.lowerBound(s, x + 1) - 1)
            idx_s_upper = array_util_lowerBound(s, x + 1) - 1
            idx_s = max(0, idx_s_upper)
            
            # Index for t: Math.max(0, ArrayUtil.lowerBound(t, x + 1) - 1)
            idx_t_upper = array_util_lowerBound(t, x + 1) - 1
            idx_t = max(0, idx_t_upper)

            # Index for s: ArrayUtil.lowerBound(s, x)
            idx_s_lower = array_util_lowerBound(s, x)
            
            # Index for t: ArrayUtil.lowerBound(t, x)
            idx_t_lower = array_util_lowerBound(t, x)


            sl = x - s[idx_s]
            tl = x - t[idx_t]
            sr = s[idx_s_lower] - x
            tr = t[idx_t_lower] - x

            result = min(
                math.max(sl, tl),
                math.max(sr, tr),
                2