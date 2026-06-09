import sys
from collections import defaultdict

class InputReader:
    def __init__(self):
        # Read all input tokens into a list
        self.tokens = sys.stdin.read().split()
        self.token_index = 0

    def next_string(self):
        if self.token_index >= len(self.tokens):
            raise EOFError("No more input tokens.")
        token = self.tokens[self.token_index]
        self.token_index += 1
        return token

    def next_int(self):
        try:
            return int(self.next_string())
        except EOFError:
            # Handle case where input ends unexpectedly
            raise ValueError("End of input reached while expecting integer.")

    def next_int_array(self, n):
        res = []
        for _ in range(n):
            try:
                res.append(self.next_int())
            except ValueError:
                # Stop if input runs out
                break
        return res

class TaskD:
    def solve(self, in_reader, out_writer):
        try:
            n = in_reader.next_int()
            m = in_reader.next_int()
            a = in_reader.next_int_array(n)
        except ValueError:
            # Handle case where N, M, or A cannot be read
            return

        # dp maps key -> count
        dp = defaultdict(int)
        ans = 0
        base = 0

        for i in range(n):
            # 1. Update base
            # base = (base - a[i] % m + m) % m
            base = (base - (a[i] % m) + m) % m
            
            # 2. Update dp
            # key = (base + a[i]) % m
            key = (base + a[i]) % m
            dp[key] += 1
            
            # 3. Update ans
            # ans += dp.get(base, 0)
            ans += dp[base]

        out_writer.write(str(ans) + "\n")

def main():
    # Setup input/output handling
    in_reader = InputReader()
    
    # Use sys.stdout for output writing
    out_writer = sys.stdout
    
    solver = TaskD()
    solver.solve(in_reader, out_writer)

if __name__ == "__main__":
    main()