import sys
import io

# Set recursion limit higher for DP
# Assuming N is small enough (e.g., N <= 20)
sys.setrecursionlimit(3000)

class Main:
    # Global/State variables
    n = 0
    a = None
    memo = None

    class Pair:
        def __init__(self, a: int, b: int):
            self.l = a
            self.r = b

        def __str__(self):
            return f"{self.l} {self.r}"

    @staticmethod
    def dp(fliped: int, idx: int, msk: int) -> int:
        # Base case: all elements used
        if msk == (1 << Main.n) - 1:
            return 0
        
        # Memoization check
        if Main.memo[flip_state][idx][mask] != -1:
            return Main.memo[flip_state][idx][mask]

        # Initialize the current state for memoization
        Main.memo[flip_state][idx][mask] = -1
        
        # The logic in the original Java code seems to use 'flip_state' and 'idx' 
        # as indices, but the provided snippet only shows the function signature 
        # and the core logic. Assuming the state variables are passed correctly 
        # or derived from the context. We will use the provided variables:
        
        # Re-evaluating the state variables based on the provided structure:
        # The original code snippet seems to imply that the function signature 
        # is: solve(flip_state, idx, mask)
        
        # Since we cannot fully replicate the state management without the full context, 
        # we will assume the function signature is correct and proceed with the logic flow.
        
        # --- Start of core logic replication ---
        
        min_val = float('inf')
        
        # Iterate through all possible next elements (j)
        for j in range(Main.n):
            # Check if element j is not yet used (i.e., bit j is 0 in mask)
            if not ((mask >> j) & 1):
                
                # Calculate the next state variables
                next_mask = mask | (1 << j)
                next_flip_state = (flip_state + 1) % 2
                next_idx = (idx + 1) % Main.n
                
                # Calculate the value for this step
                current_val = Main.a[j]
                
                # Determine the value to add based on the current state (flip_state)
                if flip_state == 0:
                    # If flip_state is 0, we add the value directly
                    value_to_add = current_val
                else:
                    # If flip_state
