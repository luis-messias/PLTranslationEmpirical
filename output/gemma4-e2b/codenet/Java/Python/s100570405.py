import sys
import math

class MyInput:
    def __init__(self):
        # In a real scenario, this class would handle reading from sys.stdin
        # For this translation, we will simulate reading tokens directly if possible,
        # or rely on standard input reading methods.
        pass

    def next(self):
        # Simulate reading a string token from input
        try:
            return sys.stdin.readline().strip()
        except EOFError:
            raise StopIteration

    # The rest of the methods (nextLong, nextInt, nextDouble) are complex
    # and rely on specific byte-level parsing which is highly dependent on
    # the exact input stream format. Since the core logic only uses next()
    # for strings Sd and T, we simplify the input handling to focus on the algorithm.
    # We will assume Sd and T are read successfully.

class Main:
    def run(self):
        # Read Sd and T using the simulated input mechanism
        try:
            Sd = sys.stdin.readline().strip()
            T = sys.stdin.readline().strip()
        except:
            # Handle case where input might fail immediately
            return

        if not Sd or not T:
            return

        n_s = len(Sd)
        n_t = len(T)
        ok = False
        first = -1
        end = -1

        # Core matching logic replication
        # The Java logic iterates over potential starting positions in Sd (j)
        # and checks for a match of T starting at that position.
        
        # We iterate over all possible starting positions in Sd where T could fit.
        for j in range(n_s - n_t + 1):
            # Check if Sd[j : j + n_t] matches T (allowing '?' wildcard)
            match = True
            for k in range(n_t):
                s_char = Sd[j + k]
                t_char = T[k]
                
                if t_char != '?' and s_char != t_char:
                    match = False
                    break
            
            if match:
                # Found a match
                first = j
                end = j +