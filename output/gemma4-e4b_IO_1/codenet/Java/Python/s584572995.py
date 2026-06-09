import sys

# Set recursion limit higher for deep DFS on trees
sys.setrecursionlimit(200000)

def solve():
    # Fast input reading setup
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # Read N
    N = int(input_data[0])
    
    mod = 10**9 + 7
    
    if N == 1:
        # Special case: 1 vertex, 0 edges.
        # ans = 0
        print(0)
        return

    # Initialize adjacency list
    to = [[] for _ in range(N)]
    
    # Read edges
    edges = []
    data_idx = 1
    for i in range(N - 1):
        # Input is 1-based, convert to 0-based
        A = int(input_data[data_idx]) - 1
        B = int(input_data[data_idx+1]) - 1
        data_idx += 2
        
        to[A].append(B)
        to[B].append(A)
        edges.append((A, B))

    # dp[i] will store the size of the subtree rooted at i
    dp = [0] * N

    # --- Modular Exponentiation ---
    def modpow(x, y):
        return pow(x, y, mod)

    # --- DFS/DP Calculation (rec) ---
    def rec(v, parent):
        res = 1
        for next_node in to[v]:
            if next_node == parent:
                continue
            # Correctly replicate the Java logic: assign and return
            res += rec(next_node, v)
        return dp[v] = res

    # Start DFS from node 0 (arbitrary root)
    rec(0, -1)

    # --- Main Calculation ---
    
    # 1. Calculate mulsum (Sum of (2^a - 1) * (2^b - 1) for all edges)
    mulsum = 0
    for e in edges:
        candidate1, candidate2 = e
        
        # Replicating the Java logic:
        # int child = candidate1;
        # if(dp[candidate1]>dp[candidate2])child = candidate2;
        
        child = candidate1
        if dp[candidate1] > dp[candidate2]:
            child = candidate2
        
        # a = size of the subtree rooted at the 'child' side
        a = dp[child]
        # b = size of the remaining part (N - a)
        b = N - a

        # Calculate (2^a - 1) * (2^b - 1) % mod
        
        # term_a = (2^a - 1) % mod
        term_a = (modpow(2, a) - 1 + mod) % mod
        # term_b = (2^b - 1) % mod
        term_b = (modpow(2, b) - 1 + mod) % mod
        
        mul = (term_a * term_b) % mod
        
        mulsum = (mulsum + mul) % mod

    # 2. Calculate PN (Total sum of included vertices across all 2^N cases)
    # PN = (mulsum + (2^N - 1)) % mod
    
    # The term (2^N - 1) is calculated as (2^N - 1) % mod
    pow_2_n_minus_1 = (pow(2, len(input_data)) - 1) % (10**9 + 7) # Assuming modulus 10^9 + 7 if needed, but sticking to direct calculation based on problem context
    
    # Since the problem description does not specify a modulus, we assume standard integer arithmetic for the intermediate steps, 
    # but use the standard formula for the sum: Sum = Sum_edges + (2^N - 1)
    
    # Re-evaluating the formula for 2^N - 1:
    pow_2_n = pow(2, len(input_data))
    pow_2_n_minus_1 = (pow_2_n - 1)
    
    # If we assume the problem implies a modulus M (e.g., 10^9 + 7), we must apply it consistently. 
    # Since no modulus is given, we proceed assuming standard integer types are sufficient for the intermediate sum.
    
    # Based on the structure, the formula is: Sum = Sum_edges + (2^N - 1)
    total_sum = (total_sum + pow_2_n_minus_1)
    
    # NOTE: The original code snippet was missing the calculation for the second part of the sum. 
    # Assuming the full formula for the sum is: Sum = Sum_edges + (2^N - 1)
    
    # Let's correct the variable usage for the final sum calculation based on the structure:
    # total_sum = (total_sum + pow_2_n_minus_1) # This line is conceptually correct if the previous line was correct.
    
    # Since the provided code structure was incomplete for the final sum, we rely on the established formula:
    # Sum = Sum_edges + (2^N - 1)
