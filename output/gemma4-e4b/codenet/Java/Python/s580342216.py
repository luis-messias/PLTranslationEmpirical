import sys

class Solution:
    def __init__(self):
        # Read all lines from standard input
        self.input_lines = sys.stdin.readlines()
        
    def run_case(self):
        # Reads the next line from the stored input lines
        if not self.input_lines:
            return False
        
        line = self.input_lines.pop(0).strip()
        if not line:
            return False

        try:
            parts = line.split()
            if len(parts) < 2:
                return False
                
            N = int(parts[0])
            K = int(parts[1])
        except ValueError:
            return False

        # Calculate the number of digits of N in base K
        len_digits = 0
        temp_N = N
        while temp_N > 0:
            temp_N //= K
            len_digits += 1
        
        print(len_digits)
        return True

    def process_all_cases(self):
        # Mimics the Java while (scanner.hasNext()) loop
        while self.run_case():
            pass

    # Helper method (kept for structural completeness, though unused in the main logic flow)
    def str_to_int_array(self, str_val):
        vals = str_val.split()
        res = [int(v) for v in vals]
        return res

class LCS:
    def __init__(self):
        self.dp = None

    def lcs(self, A: str, B: str) -> int:
        sz_a = len(A)
        sz_b = len(B)
        self.dp = [[0] * (sz_b + 1) for _ in range(sz_a + 1)]

        for i in range(sz_a + 1):
            for j in range(sz_b + 1):
                if i > 0 and j > 0:
                    if A[i-1] == B[j-1]:
                        self.dp[i][j] = self.dp[i-1][j-1] + 1
                    else:
                        self.dp[i][j] = max(self.dp[i-1][j], self.dp[i][j-1])
        
        return self.dp[sz_a][sz_b]

    def get_lcs(self, X: str, Y: str) -> str:
        m = len(X)
        n = len(Y)
        
        # Calculate DP table first
        lcs_length = self.lcs(X, Y)
        
        # Traceback logic
        lcs_chars = []
        i, j = m, n
        
        while i > 0 and j > 0:
            if X[i-1] == Y[j-1]:
                # Character is part of LCS
                lcs_chars.append(X[i-1])
                i -= 1
                j -= 1
            elif self.dp[i-1][j] > self.dp[i][j-1]:
                # Move up (X[i-1] was not part of the optimal path)
                i -= 1
            else:
                # Move left (Y[j-1] was not part of the optimal path)
                j -= 1
        
        # The characters were collected in reverse order
        return "".join(lcs_chars[::-1])

# --- Main Execution ---
# The original Java structure implies that the Solution class handles the primary execution flow
# and the LCS class is defined separately but available.

if __name__ == "__main__":
    # Initialize and run the Solution class to handle the input test cases
    solution = Solution()
    solution.process_all_cases()
    
    # Note: If the LCS functionality needed to be tested, it would be called here, 
    # e.g., lcs_solver = LCS()
    # print(lcs_solver.get_lcs("AGGTAB", "GXTXAYB"))