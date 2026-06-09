import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N and M are the first two inputs
    n = int(data[0])
    m = int(data[1])
    
    # a array initialization (size m+1)
    # We need m elements from the rest of the data stream
    if len(data) < 2 + m:
        # Handle case where input might be incomplete based on M
        return
        
    a = [0] * (m + 1)
    for i in range(1, m + 1):
        a[i] = int(data[i + 1])

    # cnt array initialization (size n+1)
    cnt = [0] * (n + 1)
    cnt[0] = 1
    MOD = 1000000007

    # --- Logic replication ---

    # The Java code reads a[1] through a[m] inside the loop, which is slightly unusual
    # Let's check the Java loop again:
    # for (int i = 1; i < a.length; i++) { a[i] = sc.nextInt(); }
    # a.length is m+1. i runs from 1 to m. It reads m values.
    # This confirms a[1]...a[m] are read.

    # The Java code reads the rest of the input *after* N and M.
    # If we read all tokens at once, we must ensure we read exactly N, M, and M elements of A.

    # Re-reading input based on typical competitive programming style where input is streamed:
    # If we assume the input stream provides N, M, then M values for A.
    
    # Let's reset and read sequentially using standard input reading if possible, 
    # or assume the provided structure implies reading N, M, then M values.
    
    # Since the provided Java code reads N, M, and then M subsequent integers, 
    # we rely on the input stream providing exactly N, M, and M values for A.
    
    # If we use the data list approach:
    # data[0] = N, data[1] = M, data[