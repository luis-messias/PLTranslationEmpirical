import sys

class FastScanner:
    def __init__(self):
        self.inp = sys.stdin.readline

    def nextInt(self) -> int:
        return int(next(self))

    def nextLong(self) -> int:
        return int(next(self))

    def nextDouble(self) -> float:
        return float(next(self))

    def next(self) -> str:
        return next(self.inp).strip()

def main():
    fs = FastScanner()
    n = fs.nextInt()
    a = [fs.nextInt() for _ in range(n)]
    a.sort()
    sum_val, count = 0, 0
    for i in range(n-1):
        sum_val += a[i]
        if a[i+1] <= 2 * sum_val:
            count += 1
        else:
            count = 0
    print(count + 1)

if __name__ == "__main__":
    main()
