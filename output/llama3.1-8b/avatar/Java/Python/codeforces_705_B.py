import sys
from collections import defaultdict

class FastReader:
    def __init__(self):
        self.br = sys.stdin

    def next(self):
        while not hasattr(self, 'st') or not self.st:
            try:
                self.st = self.br.readline().split()
            except Exception as e:
                print(e)
        return self.st.pop(0)

    def nextInt(self):
        return int(self.next())

    def nextLong(self):
        return int(self.next())

    def nextDouble(self):
        return float(self.next())

    def nextLine(self):
        try:
            return self.br.readline().strip()
        except Exception as e:
            print(e)
            return ""

class Codeforces_705_B:
    scan = FastReader()

    @staticmethod
    def solve():
        t = Codeforces_705_B.scan.nextInt()
        arr = [Codeforces_705_B.scan.nextInt() for _ in range(t)]
        prev_winner = 0

        for i, num in enumerate(arr):
            if num == 1:
                if prev_winner == 0:
                    prev_winner = 2
            if prev_winner == 2 or prev_winner == 0:
                if (num - 1) % 2 == 0:
                    print(2)
                    prev_winner = 2
                else:
                    print(1)
                    prev_winner = 1
            else:
                if (num - 1) % 2 == 0:
                    print(1)
                    prev_winner = 1
                else:
                    print(2)
                    prev_winner = 2

    @staticmethod
    def main():
        t = 1
        while t > 0:
            Codeforces_705_B.solve()
            t -= 1

if __name__ == "__main__":
    Codeforces_705_B.main()