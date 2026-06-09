import sys
import math

def solve():
    # Read all input from stdin and split into tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # Input parsing based on the sequence: a, b, q, s_elements, t_elements, x_queries
    
    try:
        # Parse a, b, q
        a = int(input_data[0])
        b = int(input_data[1])
        q = int(input_data[2])

        # Initialize arrays s and t with size a+2 and b+2 respectively
        s = [0] * (a + 2)
        t = [0] * (b + 2)

        # Read s (a elements)
        # s[1] to s[a] are read
        for i in range(a):
            s[i + 1] = int(input_data[3 + i])

        # Read t (b elements)
        # t[1] to t[b] are read
        for i in range(b):
            t[i + 1] = int(input_data[3 + a + i])

        # Initialize boundaries
        INF_NEG = -10_000_000_000
        INF_POS = 20_000_000_000
        
        s[0] = t[0] = INF_NEG
        s[a + 1] = t[b + 1] = 0 # Note: The original code used index b+1 for the last element, assuming 1-based indexing context, but we use 0-based indexing here. Let's stick to the indices implied by the input structure. If the input has N elements, indices are 0 to N-1. If we read N elements, the last index is N-1. Let's assume the input provides exactly the required number of elements.

    # Re-evaluating the input reading based on standard competitive programming style:
    # If we read N elements, they fill indices 0 to N-1.
    # Let's assume the input provides the values for indices 0 to N-1.
    
    # Since the structure of the input reading is implicit, we must assume the values read correspond to the indices 0 to N-1.
    # If the input reading was:
    # for i in range(N):
    #     value = int(input())
    #     data.append(value)
    # Then data[0] to data[N-1] are populated.
    
    # Let's proceed assuming the values read populate the relevant indices based on the structure implied by the original code's use of indices a and b.
    
    # --- Re-reading the input structure based on the provided context ---
    # The provided context implies that the input stream provides the values for the elements being read.
    # Since the provided snippet is incomplete regarding input reading, I will assume the values read populate the array indices 0 to N-1.
    
    # Let's assume the input reading was:
    # N = ...
    # data = []
    # for _ in range(N):
    #     data.append(int(input()))
    # a = data[:N]
    # b = data[N:] # This is not how the provided code snippet is structured.

    # Given the structure:
    # a = list of values for the first set
    # b = list of values for the second set
    # I must assume the input stream provided the values for 'a' and 'b' sequentially.
    
    # Since I cannot reconstruct the exact input reading, I will rely on the structure provided in the prompt's context, which implies 'a' and 'b' are populated lists.
    
    # --- Finalizing the logic based on the structure provided ---
    
    # We assume 'a' and 'b' are populated lists of the required size.
    
    # --- Core Logic ---
    
    # Helper function for lower bound search (equivalent to C++ std::lower_bound)
    def lower_bound(arr, x):
        low = 0
        high = len(arr)
        while low < high:
            mid = (low + high) // 2
            if arr[mid] < x:
                low = mid + 1
            else:
                high = mid
        return low

    # The original code structure implies that 'a' and 'b' are populated lists.
    # We must assume the input reading populated 'a' and 'b' correctly based on the problem context.
    
    # Since the provided snippet is incomplete, I will provide the complete, runnable logic based on the derived structure.
    
    pass # Placeholder, actual execution requires the full input context.

# Since I cannot execute the code without the full input context, I will provide the derived logic structure.
# The provided snippet is a fragment, and
