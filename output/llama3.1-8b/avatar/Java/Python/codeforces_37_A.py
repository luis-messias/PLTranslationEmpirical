from collections import defaultdict
import sys

class FastScanner:
    def __init__(self):
        self.br = sys.stdin

    def next(self):
        while True:
            try:
                return next(self.br).strip()
            except StopIteration:
                pass

    def nextInt(self):
        return int(self.next())

    def nextLong(self):
        return int(self.next())

    def nextDouble(self):
        return float(self.next())

def main():
    input = FastScanner()
    n = input.nextInt()
    map_ = defaultdict(int)
    for _ in range(n):
        val = input.nextInt()
        map_[val] += 1

    max_val = 0
    for key, value in map_.items():
        max_val = max(max_val, value)

    print(str(max_val) + str(len(map_)))

if __name__ == "__main__":
    main()