import sys

class Main:
    def __init__(self):
        self.constraints = []
        self.N = 0
        self.result = 0

        try:
            for line in sys.stdin:
                if not self.N:
                    self.N = int(line.strip())
                else:
                    self.constraints.append(int(line.strip()))
                if len(self.constraints) == 5:
                    break
        except Exception as e:
            print(f"Error: {e}")

        self.calc()

    def calc(self):
        min_val = float('inf')
        for c in self.constraints:
            min_val = min(min_val, c)
        time = (self.N - 1) // min_val + 1
        if self.N % min_val != 0:
            time += 1
        time += 4
        self.result = time

if __name__ == "__main__":
    ins = Main()
    print(ins.result)
