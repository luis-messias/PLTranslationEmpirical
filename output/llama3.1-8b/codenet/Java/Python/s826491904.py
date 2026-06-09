import sys

class Main:
    def __init__(self):
        self.sc = input

    def solve(self):
        N = int(input())
        max_val, min_val = map(int, input().split())
        for _ in range(1, N):
            val = int(input())
            max_val = max(max_val, val)
            min_val = min(min_val, val)
        print(max_val - min_val)

if __name__ == "__main__":
    Main().solve()