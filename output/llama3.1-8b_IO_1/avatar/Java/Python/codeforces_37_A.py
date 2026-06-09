from collections import defaultdict, Counter
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

    def nextInts(self):
        return list(map(int, self.next().split()))

def main():
    input = FastScanner()
    n = len(input.nextInts())
    map_ = Counter()
    for val in input.nextInts():
        map_[val] += 1

    max_val = max(map_.values())
    print(str(max_val) + str(len(map_)))

if __name__ == "__main__":
    main()
