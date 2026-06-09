import sys

# Set recursion limit higher for deep DFS on trees
sys.setrecursionlimit(200000)

def solve():
    # Fast input reading setup
    input = sys.stdin.read
    data = input().split()
    
    if not data:
        return

    N = int(data[0])
    
    if N == 1:
        # Special case: 1 vertex, 0 edges. 
        # Total cases = 2^1 = 2.
        # Black vertices (B): 1 * 2^(1-1) = 1.
        # White vertices (W): (PN - BN) / 2^1.
        # PN = (0 + (2 - 1)) % mod = 1.
        # WN = (1 - 1 + mod) % mod = 0.
        # ans = 0 * (2)^-1 = 0.
        print(0)
        return

    mod = 10**9 + 7
    
    # Initialize adjacency list
    to = [[] for _ in range(N)]
    
    # Read edges
    edges = []
    data_idx = 1
    for i in range(N - 1):
        # Input is 1-based, convert to 0-based
        A = int(data[data_idx]) - 1
        B = int(data[data_idx+1]) - 1
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
            res += rec(next_node, v)
        return dp[v] = res

    # Start DFS from node 0 (arbitrary root)
    rec(0, -1)

    # --- Main Calculation ---
    
    # 1. Calculate mulsum (Sum of (2^a - 1) * (2^b - 1) for all edges)
    mulsum = 0
    for e in edges:
        candidate1, candidate2 = e
        
        # Determine which node is the child (the one whose subtree size is smaller 
        # relative to the other, or simply, the one that is not the root's side 
        # if we consider the edge (A, B) and root at 0).
        # The Java logic determines the child based on which node has a larger DP value 
        # when considering the edge (A, B) and the root 0.
        # If dp[A] > dp[B], B is likely closer to the root 0, and A is the child side.
        # Let's stick to the logic: child = candidate2 if dp[candidate1] > dp[candidate2] else candidate1
        
        # Wait, the Java logic is:
        # int child = candidate1;
        # if(dp[candidate1]>dp[candidate2])child = candidate2;
        # This means if dp[A] > dp[B], child = B. Otherwise, child = A.
        # This seems counter-intuitive for standard tree DP, but we must replicate the logic.
        
        candidate1 = e[0]
        candidate2 = e[1]
        
        child = candidate1
        if dp[candidate1] > dp[candidate2]:
            child = candidate2
        
        # a = size of the subtree rooted at the 'child' side
        a = dp[child]
        # b = size of the remaining part (N - a)
        b = N - a

        # Calculate (2^a - 1) * (2^b - 1) % mod
        # Note: We must handle the subtraction carefully with modulo arithmetic.
        
        term_a = (modpow(2, a) - 1 + mod) % mod
        term_b = (modpow(2, b) - 1 + mod) % mod
        
        mul = (term_a * term_b) % mod
        
        mulsum = (mulsum + mul) % mod

    # 2. Calculate PN (Total sum of included vertices across all 2^N cases)
    # PN = (mulsum + (2^N -