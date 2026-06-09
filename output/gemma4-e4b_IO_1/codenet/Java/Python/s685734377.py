import sys

# Increase recursion limit for safety, although not strictly necessary for this problem structure
# sys.setrecursionlimit(2000)

class FastScanner:
    """
    A simplified FastScanner equivalent for reading tokens from stdin.
    Reads all available tokens from sys.stdin.
    """
    def __init__(self, input_stream):
        self.input_stream = input_stream
        self.buffer = []
        self.token_index = 0
        self._read_line()

    def _read_line(self):
        # Read all available lines and tokenize them
        # Reading all lines at once is necessary to mimic the behavior of reading from a stream
        # until all tokens are available, as done by the original Java implementation structure.
        try:
            lines = sys.stdin.readlines()
        except Exception:
            lines = []
            
        self.buffer = []
        for line in lines:
            self.buffer.extend(line.strip().split())
        self.token_index = 0

    def next(self):
        if self.token_index < len(self.buffer):
            token = self.buffer[self.token_index]
            self.token_index += 1
            return token
        return None

    def next_int(self):
        token = self.next()
        if token is None:
            raise EOFError("End of input reached")
        return int(token)

class TaskB:
    def solve(self, test_number, in_scanner, out_writer):
        try:
            n = in_scanner.next_int()
        except EOFError:
            return

        # Read the grid A
        a = []
        for _ in range(n):
            line = in_scanner.next()
            if line is None:
                # Handle case where input might end prematurely
                return
            a.append(list(line))

        # Constants
        P = 37
        Q = 47

        # Precalculate powers
        powP = [1] * (n + 1)
        powQ = [1] * (n + 1)
        for i in range(1, n + 1):
            powP[i] = powP[i - 1] * P
            powQ[i] = powQ[i - 1] * Q

        # Initialize hash arrays
        # hashRow[i][k] stores the hash for row i, related to offset k
        hashRow = [[0] * n for _ in range(n)]
        # hashCol[j][k] stores the hash for column j, related to offset k
        hashCol = [[0] * n for _ in range(n)]

        # Calculate hashes
        for i in range(n): # Row index
            for j in range(n): # Column index (source of character)
                char_val = ord(a[i][j])
                for k in range(n): # Hash index
                    # hashRow[i][k] += a[i][j] * P^((j - k) mod n)
                    power_p = powP[(j - k + n) % n]
                    hashRow[i][k] += char_val * power_p
                    
                    # hashCol[j][k] += a[i][j] * P^((i - k) mod n)
                    power_p_col = powP[(i - k + n) % n]
                    hashCol[j][k] += char_val * power_p_col

        # Count pairs (A, B) satisfying the condition
        ans = 0
        for A in range(n):
            for B in range(n):
                ok = True
                for i in range(n):
                    # Check if hashRow[(i + A) % n][B] == hashCol[(i + B) % n][A]
                    if hashRow[(i + A) % n][B] != hashCol[(i + B) % n][A]:
                        ok = False
                        break
                
                if ok:
                    ans += 1
        
        out_writer.write(str(ans) + "\n")

def main():
    # Use sys.stdin and sys.stdout for input/output
    input_stream = sys.stdin
    output_stream = sys.stdout
    
    # Initialize FastScanner and TaskB
    in_scanner = FastScanner(input_stream)
    
    solver = TaskB()
    # The original Java calls solve(1, in, out)
    solver.solve(1, in_scanner, output_stream)

if __name__ == "__main__":
    main()
