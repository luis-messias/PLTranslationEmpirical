import sys

# Set recursion limit higher for deep DFS calls
# The original Java code uses DFS, which might hit stack limits if N is large.
# Assuming N is small enough for standard recursion limits, but increasing it is safer.
# sys.setrecursionlimit(2000) 

class Solver:
    def __init__(self, input_data):
        # input_data is assumed to be a list of tokens read from stdin
        self.data_iter = iter(input_data)
        
    def next_int(self):
        try:
            return int(next(self.data_iter))
        except StopIteration:
            raise EOFError("End of input")

    def run(self):
        try:
            # Read N, M, Q
            self.n = self.next_int()
            self.m = self.next_int()
            self.q = self.next_int()
        except EOFError:
            return

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
        # Base Case: array length > n
        if len(current_array) > self.n:
            score = 0
            for i in range(self.q):
                # Check condition: array[b[i]] - array[a[i]] == c[i]
                # Note: The indices a[i] and b[i] refer to positions in the sequence.
                # Since the sequence is 1-indexed in the problem context (implied by the Java code structure 
                # and the nature of the problem), we assume a[i] and b[i] are 1-based indices 
                # corresponding to positions in the sequence.
                # Python lists are 0-indexed. If a[i] and b[i] are 1-based indices, 
                # we must access current_array[index - 1].
                
                # Assuming