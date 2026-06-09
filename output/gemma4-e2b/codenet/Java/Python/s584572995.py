import sys

# Set recursion limit higher for deep DFS/DP calls
sys.setrecursionlimit(2000)

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # FastScanner equivalent setup
    fs = iter(input_data)
    
    def next_int():
        return int(next(fs))

    MOD = 10**9 + 7

    N = next_int()
    
    if N == 0:
        print(0)
        return

    to = [[] for _ in range(N)]
    
    # Read N-1 edges
    edges = []
    for i in range(N - 1):
        A = next_int() - 1
        B = next_int() - 1
        
        to[A].append(B)
        to[B].append(A)
        
        # Store edges for later calculation (A, B)
        edges.append((A, B))

    # DP array
    dp = [0] * N

    # DFS to calculate subtree sizes (dp[v] = size of subtree rooted at v)
    def rec(v, parent):
        res = 1
        for next_node in to[v]:
            if next_node != parent:
                res += rec(next_node, v)
        dp[v] = res
        return res

    # Start DFS from node 0 (assuming the graph is connected, which is typical for tree problems)
    rec(0, -1)

    # --- Core Calculation ---
    
    mulsum = 0
    
    # edges stores the pairs (A, B) corresponding to the N-1 edges
    for A, B in edges:
        # Determine which node is the child based on DP values
        # The edge (A, B) splits the tree into two components.
        # We need to identify the subtree size associated with the split.
        
        # Since the DP calculation (rec(0, -1)) implicitly roots the tree at 0, 
        # we need to figure out which node is the 'child' relative to the DP structure.
        # The DP values calculated are based on the arbitrary rooting at 0.
        
        # The logic in the Java code compares dp[candidate1] and dp[candidate2]
        # to find the size of the component created by removing the edge.
        
        candidate1 = A
        candidate2 = B
        
        # If dp[A] is the size of the component containing A when the edge (A, B) is cut,
        # then the other component size is N - dp[A].
        
        # We must ensure that the DP values calculated by rec(0, -1) correctly represent 
        # the sizes of the two components formed by removing the edge (A, B).
        
        # If we consider the edge (A, B), removing it splits the tree into two components.
        # One component contains A and the other contains B.
        # If we assume A is the parent of B in the DFS tree rooted at 0, then dp[B] is the size of the subtree rooted at B.
        
        # The Java code determines the child based on which DP value is smaller/larger, 
        # which is a standard way to identify the subtree size when an edge is considered.
        
        if dp[candidate1] > dp[candidate2]:
            child = candidate2
        else:
            child = candidate1
            
        a = dp[child]
        b = N - a

        # mul = (2^a - 1) * (2^b - 1) mod MOD
        # This counts the number of ways to color the two components such that at least one node is black.
        
        # Calculate 2^a - 1 mod MOD
        term_a = (pow(2, a, MOD) - 1 + MOD) % MOD
        # Calculate 2^b - 1 mod MOD
        term_b = (pow(2, b, MOD) - 1 + MOD) % MOD
        
        mul = (term_a * term_b) % MOD
        mulsum = (mulsum + mul) % MOD

    # Calculate total cases: 2^N
    cases = pow(2, N, MOD)
    
    # PN: Sum of subtree sizes (related to the sum of sizes of components)
    # PN = mulsum + (cases - 1) mod MOD
    # The Java code calculates: PN = (mulsum + (cases - 1 + mod)%mod)%mod
    PN = (mulsum + (cases - 1)) % MOD
    
    # BN: Sum of black nodes (related to N * 2^(N-1))
    # BN = N * 2^(N-1) mod MOD
    BN = (N * pow(2, N -