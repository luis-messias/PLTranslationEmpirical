import sys
import io

# Set recursion limit higher for DP
sys.setrecursionlimit(2000)

class Main:
    def __init__(self):
        # Global/State variables
        self.n = 0
        self.a = None
        self.memo = None

    @staticmethod
    def dp(fliped: int, idx: int, msk: int) -> int:
        # Base case: all elements used
        if msk == (1 << Main.n) - 1:
            return 0
        
        # Memoization check
        if Main.memo[fliped][idx][msk] != -1:
            return Main.memo[fliped][idx][msk]

        # x = number of set bits in msk (number of elements already used)
        x = bin(msk).count('1')
        
        ff = 0
        ans = float('inf')
        
        # Temporary variable to track the count of used elements for the loop logic
        # This variable mimics the behavior of 'x' in the Java code.
        current_x = x 

        for i in range(Main.n):
            # Check if the i-th element is unused
            if (msk & (1 << i)) == 0:
                # Calculate nf based on the current value of x
                nf = current_x % 2
                
                # Check condition: idx == n OR a[fliped][idx] <= a[(nf + ff % 2) % 2][i]
                # Note: Python uses 0-based indexing, so we must handle the array access carefully.
                
                # The Java code uses a[fliped][idx] and a[...][i].
                # Since 'idx' is passed into dp, we assume it is a valid index for 'a[fliped]'.
                
                condition_met = False
                if idx == Main.n:
                    condition_met = True
                else:
                    # a[fliped][idx] <= a[(nf + ff % 2) % 2][i]
                    if Main.a[fliped][idx] <= Main.a[(nf + ff % 2) % 2][i]:
                        condition_met = True

                if condition_met:
                    # Calculate the next state's fliped index
                    next_fliped = (nf + ff % 2) % 2
                    
                    # Recursive call: ff + dp(next_fliped, i, msk | 1 << i)
                    result = ff + Main.dp(next_fliped, i, msk | (1 << i))
                    ans = min(ans, result)
                
                ff += 1
            else:
                # If element i is used, decrement the tracking variable x
                current_x -= 1
        
        # Store and return the result
        Main.memo[fliped][idx][msk] = ans
        return ans

    def solve(self):
        # Input reading setup
        try:
            # Read N
            n_line = sys.stdin.readline()
            if not n_line:
                return -1
            self.n = int(n_line.strip())
        except EOFError:
            return -1
        except ValueError:
            return -1

        # Read array A[0]
        try:
            a0_line = sys.stdin.readline()
            if not a0_line:
                return -1
            self.a = [[int(x) for x in a0_line.split()], None]
        except EOFError:
            return -1
        
        # Read array A[1]
        try:
            a1_line = sys.stdin.readline()