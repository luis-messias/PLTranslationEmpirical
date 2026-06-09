import sys

class AtcoderABC149B:
    def __init__(self, tokens):
        # A, B, K are read from the first line of input
        # Python handles large integers automatically
        self.A = int(tokens[0])
        self.B = int(tokens[1])
        self.K = int(tokens[2])
        # Initialize x and y (though they are overwritten in calc)
        self.x = 0
        self.y = 0

    def calc(self):
        # Java sequence: x = A; y = B;
        self.x = self.A
        self.y = self.B
        
        # Java sequence: x = A - K;
        self.x = self.A - self.K
        
        if self.x < 0:
            # Java sequence: y = B + x;
            self.y = self.B + self.x
            # Java sequence: x = 0;
            self.x = 0
            
            if self.y < 0:
                # Java sequence: y = 0;
                self.y = 0

    def show_result(self):
        print(f"{self.x} {self.y}")

def main():
    # Read all tokens from standard input
    try:
        # Read input line and split it into tokens
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        
        tokens = input_data.split()
        
        solver = AtcoderABC149B(tokens)
        solver.calc()
        solver.show_result()
        
    except Exception:
        # Handle potential reading errors gracefully
        pass

if __name__ == "__main__":
    main()
