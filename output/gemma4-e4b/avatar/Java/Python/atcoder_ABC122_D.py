import sys

class atcoder_ABC122_D:
    TOKENS = ["A", "C", "G", "T"]
    MOD = 1000000007

    def __init__(self):
        # Read N from standard input
        try:
            # Read the single integer N
            N = int(sys.stdin.read().strip())
        except:
            # Handle case where input might be empty or malformed
            N = 0
        
        self.N = N
        # Initialize memoization table: list of dictionaries
        self.memo = [{} for _ in range(N + 1)]

    def calc(self):
        # Start DFS from current=0, last3="TTT"
        return self.dfs(0, "TTT")

    def is_ok(self, last4: str) -> bool:
        # Constraint 1: Check if last4 contains "AGC"
        if "AGC" in last4:
            return False
        
        # Constraint 2: Check swaps
        # We must replicate the sequential modification of the character array from Java
        
        # Start with a mutable list representation of last4
        vals = list(last4)
        
        # The loop runs for i = 0, 1, 2 (since last4 has length 4)
        for i in range(3):
            # Swap logic: vals[i] <-> vals[i+1]
            # Note: The Java code uses the original last4 characters for the swap values, 
            # but applies them to the current state of 'vals'.
            
            # Java: vals[i] = last4.charAt(i + 1);
            # Java: vals[i + 1] = last4.charAt(i);
            
            # To replicate the Java behavior exactly (where the swap uses the original