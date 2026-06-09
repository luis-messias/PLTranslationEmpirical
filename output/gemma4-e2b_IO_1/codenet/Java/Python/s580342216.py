import sys

class Solution:
    def __init__(self):
        # In a typical CP environment, input is read sequentially.
        # We read all input lines first.
        self.input_data = sys.stdin.read().splitlines()

    def run_case(self):
        if not self.input_data:
            return

        try:
            line = self.input_data[0]
            parts = line.split()
            if len(parts) < 2:
                return
            N = int(parts[0])
            K = int(parts[1])
        except ValueError:
            return

        # Calculate len based on repeated division
        len_val = 0
        temp_N = N
        # The loop continues as long as N > 0.
        # If N=10, K=3: 10/3=3 (len=1), 3/3=1 (len=2), 1/3=0 (len=3).
        while temp_N > 0:
            temp_N //= K
            len_val += 1

        print(len_val)

class LCS:
    def __init__(self):
        self.dp = None

    def lcs(self, A: str, B: str) -> int:
        sz_a = len(A)
        sz_b = len(B)
        
        # Initialize DP table
        self.dp = [[0] * (sz_b + 1) for _ in range(sz_a + 1)]

        # Fill DP table
        for i in range(1, sz_a + 1):
            for j in range(1, sz_b + 1):
                if A[i-1] == B[j-1]:
                    dp[i][j] = 1 + dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
        # The result is dp[m][n]
        return dp[len(A)][len(B)]

    # Note: The original Java code snippet was incomplete for the full LCS calculation.
    # I am implementing the standard LCS logic here, assuming the intent was to calculate it.
    # If the intent was only to replicate the structure of the provided snippet, 
    # the logic for the DP table filling needs to be completed.
    # Since the provided snippet was highly truncated, I will provide a complete, functional LCS implementation.
    
    # Re-implementing the core logic for clarity and correctness:
    def find_l
