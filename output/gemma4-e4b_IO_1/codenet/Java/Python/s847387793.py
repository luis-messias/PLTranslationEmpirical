import sys

# Increase recursion limit for deep DFS calls
# The problem structure suggests N might be large enough to hit default limits.
sys.setrecursionlimit(3000)

class Solver:
    def __init__(self, input_data):
        # Use an iterator for sequential reading of input tokens
        self.data_iter = iter(input_data)
        
    def next_int(self):
        """Reads the next integer from the input stream."""
        try:
            return int(next(self.data_iter))
        except StopIteration:
            # Handle end of input gracefully
            raise EOFError("End of input data")

    def run(self):
        """Reads input, runs the solver, and returns the maximum score."""
        try:
            # Read N, M, Q
            self.n = self.next_int()
            self.m = self.next_int()
            self.q = self.next_int()
        except EOFError:
            return 0

        # Read arrays a, b, c, d
        self.a = [self.next_int() for _ in range(self.q)]
        self.b = [self.next_int() for _ in range(self.q)]
        self.c = [self.next_int() for _ in range(self.q)]
        self.d = [self.next_int() for _ in range(self.q)]
        
        self.max_score = 0
        
        # Start DFS with the initial sequence [1]
        self.dfs([1])
        
        return self.max_score

    def dfs(self, current_array):
        """
        Performs Depth First Search to find the maximum score.
        current_array: The sequence built so far.
        """
        # Base Case: array length > n
        if len(current_array) > self.n:
            score = 0
            for i in range(self.q):
                # Assuming a[i] and b[i] are 0-based indices relative to the current array length.
                # If the problem intended 1-based indexing, the indices should be adjusted: 
                # current_array[self.a[i] - 1]
                
                # Following the Java structure: direct indexing
                try:
                    val_b = current_array[self.b[i]]
                    val_a = current_array[self.a[i]]
                    
                    if val_b - val_a == self.c[i]:
                        score += self.d[i]
                except IndexError:
                    # This handles cases where a[i] or b[i] might exceed the current array length
                    pass 
            
            self.max_score = max(self.max_score, score)
            return

        # Create a
