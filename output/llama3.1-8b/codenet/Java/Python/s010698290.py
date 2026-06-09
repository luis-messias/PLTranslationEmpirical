import sys
from collections import *
import math

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
        return sys.stdin.readline().strip()

class Main:
    def main(self):
        try:
            s = FastReader()
            n, m = map(int, (s.next() + ' ' + s.next()).split())
            penal = [0] * (n+1)
            solved = [False] * (n+1)

            for i in range(m):
                num = s.nextInt()
                str = s.next()
                if str[0] == 'A':
                    solved[num-1] = True
                else:
                    if not solved[num-1]:
                        penal[num-1] += 1

            correct_ans, num_penal = 0, 0
            for i in range(1, n+1):
                if solved[i-1]:
                    correct_ans += 1
                    num_penal += penal[i-1]

            print(correct_ans, num_penal)

        except Exception as e:
            print(e)

if __name__ == "__main__":
    Main().main()