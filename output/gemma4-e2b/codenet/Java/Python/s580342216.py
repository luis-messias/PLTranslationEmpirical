import sys

class Solution:
    def __init__(self):
        # Reading input from stdin
        self.input_data = sys.stdin.read().splitlines()

    def run_case(self):
        if not self.input_data:
            return

        line = self.input_data[0]
        try:
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
        while temp_N > 0:
            temp_N //= K
            len_val += 1

        print(len_val)

class LCS:
    def __init__(self):
        # dp table will be initialized in lcs method
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
                    self.dp[i][j] = self.dp[i-1][j-1] + 1
                else:
                    self.dp[i][j] = max(self.dp[i-1][j], self.dp[i][j-1])

        return self.dp[sz_a][sz_b]

    def getLCS(self, X: str, Y: str) -> str:
        m = len(X)
        n = len(Y)
        
        # Recalculate DP table if necessary (assuming lcs was called previously, 
        # but for standalone execution, we ensure it's calculated)
        if self.dp is None or len(self.dp) != (m + 1) or len(self.dp[0]) != (n + 1):
            self.lcs(X, Y)
        
        index = self.dp[m][n]
        temp = index

        # Create a character array to store the lcs string
        # The Java code used index+1 size, and lcs[index] = '\0'
        lcs_chars = [''] * (index + 1)
        lcs_chars[index] = '\0' # Set the terminating character

        # Backtracking to reconstruct the LCS
        i = m
        j = n
        current_index = index
        
        while i > 0 and j > 0:
            if X[i-1] == Y[j-1]:
                # If characters match, they are part of LCS
                lcs_chars[current_index - 1] = X[i-1]
                i -= 1
                j -= 1
                current_index -= 1
            else:
                # If not same, move to the direction of the larger value in DP table
                if self.dp[i-1][j] > self.dp[i][j-1]:
                    i -= 1
                else:
                    j -= 1

        # Extract the result. The Java code used substring(0, temp+2)
        # Since we filled lcs_chars up to index, we take the slice up to index.
        result = "".join(lcs_chars[:index])
        return result

def main():
    # The original Java code structure implies reading multiple test cases 
    # from standard input, where each line contains N and K.
    
    # Since the provided Java structure calls new Solution() and then loops 
    # calling run_case(), we simulate reading all input and processing it.
    
    # Note: The Java code structure is slightly ambiguous about how the 
    # LCS part interacts with the input reading part. We assume the input 
    # provided is structured for the Solution class logic.
    
    # If the input is just N K pairs, we process them sequentially.
    
    # We instantiate Solution to handle input reading
    solution = Solution()
    
    # The Java code structure implies that run_case is called repeatedly 
    # until no more input is available.
    solution.run_case()


if __name__ == "__main__":
    # Since the provided Java code structure is complex regarding class usage, 
    # and the input reading part seems separate from the LCS part, 
    # we focus on making