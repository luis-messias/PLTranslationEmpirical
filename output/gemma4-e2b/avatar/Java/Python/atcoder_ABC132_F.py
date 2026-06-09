import sys

def solve():
    # Read input
    try:
        # Read n and k from standard input
        data = sys.stdin.read().split()
        if not data:
            return
        n = int(data[0])
        k = int(data[1])
    except EOFError:
        return
    except IndexError:
        return

    mod = 10**9 + 7

    # 1. Calculate len array
    len_list = []
    l = 1
    while l <= n:
        # r = n // (n // l)
        r = n // (n // l)
        len_list.append(r - l + 1)
        l = r + 1
    
    q = len(len_list)
    
    # dp array size k * (q + 1)
    # We use 1-based indexing conceptually, so size is k * (q + 1)
    dp_size = k * (q + 1)
    dp = [0] * dp_size

    # 2. DP initialization (i=1 row)
    # dp[j] = len.get(j - 1) + dp[j - 1] for j=1..q
    # In 0-based indexing for dp array: dp[j] corresponds to dp[j] in Java (1-based index j)
    # dp[j] = len_list[j-1] + dp[j-1]
    for j in range(1, q + 1):
        # dp index is j (1-based)
        # dp[j] = len_list[j-1] + dp[j-1]
        dp[j] = len_list[j - 1] + dp[j - 1]

    # 3. DP transition
    # i runs from 1 to k-1 (Java: i=1 to k-1)
    for i in range(1, k):
        # j runs from 1 to q (Java: j=1 to q)
        for j in range(1, q + 1):
            # dp index for dp[i, j] is i * (q + 1) + j
            current_idx = i * (q + 1) + j
            
            # dp[i, j] = dp[i, j - 1] + dp[i - 1, q - j + 1] * len[j - 1]
            
            # dp[i, j-1] corresponds to dp[current_idx - 1]
            term1 = dp[current_idx - 1]
            
            # dp[(i-1), q - j + 1] corresponds to dp[(i-1) * (q+1) + (q - j + 1) - 1]
            # Index for dp[i-1, q-j+1] is (i-1) * (q+1) + (q - j + 1)
            prev_row_idx = (i - 1) * (q + 1) + (q - j + 1)
            term2 = dp[prev_row_idx]
            
            # len.get(j - 1) corresponds to len_list[j - 1]
            len_val = len_list[j