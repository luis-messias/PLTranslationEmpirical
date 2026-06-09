import sys

class AtcoderABC149B:
    def __init__(self, tokens):
        # A, B, K are read from the first line of input
        self.A = int(tokens[0])
        self.B = int(tokens[1])
        self.K = int(tokens[2])
        self.x = 0
        self.y = 0

    def calc(self):
        # Note: The initial assignments x=A, y=B in Java are immediately overwritten, 
        # so we only care about the final state of x and y.
        
        x = self.A - self.K
        
        if x < 0:
            y = self.B + x
            x = 0
            if y < 0:
                y = 0
        
        self.x = x
        self.y = y

    def show_result(self):
        print(f"{self.x} {self.y}")

def main():
    # Read all tokens from standard input
    try:
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        
        tokens = input_data.split()
        
        solver = AtcoderABC149B(tokens)
        solver.calc()
        solver.show_result()
        
    except Exception:
        # Handle case where input might be malformed or empty
        pass

if __name__ == "__main__":
    main()