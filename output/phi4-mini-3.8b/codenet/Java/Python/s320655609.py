import sys

class Main:
    def __init__(self):
        self.constraints = []
        N, *rest_constraints = map(int, input().split())
        for _ in range(5):
            c = int(input())
            if len(self.constraints) < 4: 
                self.constraints.append(c)
        
        min_constraint = min(self.constraints[:min(len(self.constraints), 4)])
        time_needed = N // min_constraint + (N % min_constraint != 0)

        result = time_needed * 5
        print(result)


if __name__ == "__main__":
    ins = Main()