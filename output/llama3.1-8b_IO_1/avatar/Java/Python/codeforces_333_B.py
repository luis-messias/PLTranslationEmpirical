import math
from typing import Set

class FastReader:
    def __init__(self):
        self.br = None

    def next(self) -> str:
        while not hasattr(self, 'st') or len(self.st) == 0:
            try:
                self.st = self.br.readline().split()
            except Exception as e:
                print(e)
        return self.st.pop(0)

    def nextInt(self) -> int:
        return int(self.next())

    def nextLong(self) -> int:
        return int(self.next())

    def nextDouble(self) -> float:
        return float(self.next())

    def nextLine(self) -> str:
        try:
            return self.br.readline().strip()
        except Exception as e:
            print(e)

class codeforces_333_B:
    in_reader = FastReader()
    out_writer = None

    @staticmethod
    def main():
        n, m = codeforces_333_B.in_reader.nextInt(), codeforces_333_B.in_reader.nextInt()
        banned_rows, banned_cols = set(), set()

        for _ in range(m):
            r, c = codeforces_333_B.in_reader.nextInt(), codeforces_333_B.in_reader.nextInt()
            if 1 < r < n:
                banned_rows.add(r)
            if 1 < c < n:
                banned_cols.add(c)

        answer = (n - 2) * 2
        answer -= len(banned_rows)
        answer -= len(banned_cols)

        if n % 2 != 0:
            mid = (n + 1) // 2
            if mid not in banned_rows and mid not in banned_cols:
                answer -= 1

        print(answer, file=codeforces_333_B.out_writer)
        codeforces_333_B.out_writer.close()

if __name__ == "__main__":
    codeforces_333_B.out_writer = open('output.txt', 'w')
    codeforces_333_B.main()
