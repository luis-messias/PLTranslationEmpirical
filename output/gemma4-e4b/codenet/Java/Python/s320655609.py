import sys

class Main:
    def __init__(self):
        # Read all lines from standard input
        input_data = sys.stdin.read().splitlines()
        
        if not input_data:
            self.N = 0
            self.constraints = []
        else:
            # First line is N
            self.N = int(input_data[0])
            
            # Next 5 lines are constraints
            self.constraints = []
            for i in range(1, 6):
                if i < len(input_data):
                    self.constraints.append(int(input_data[i]))
                else:
                    break
        
        self.result = 0
        self.calc()

    def calc(self):
        if not self.constraints:
            self.result = 0
            return

        # Find the minimum constraint
        min_c = min(self.constraints)
        
        # Calculate time = ceil(N / min_c)
        # Using integer arithmetic for ceiling division: (a + b - 1) // b
        time = (self.N + min_c - 1) // min_c
        
        # Add 4
        time += 4
        
        self.result = time

if __name__ == "__main__":
    ins = Main()
    print(ins.result)