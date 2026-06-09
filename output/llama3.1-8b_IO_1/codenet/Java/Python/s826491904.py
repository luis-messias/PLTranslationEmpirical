import sys

class Main:
    def __init__(self):
        self.N = int(input())
        self.max_val, self.min_val = map(int, input().split())

    def solve(self):
        for _ in range(1, self.N):
            val = int(input())
            self.max_val = max(self.max_val, val)
            self.min_val = min(self.min_val, val)
        print(self.max_val - self.min_val)

if __name__ == "__main__":
    Main().solve()
