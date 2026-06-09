import sys
from math import gcd, ceil
from functools import reduce

class InputReader:
    def __init__(self):
        self.reader = sys.stdin
        self.tokenizer = None

    def next(self):
        while not self.tokenizer or not self.tokenizer.has_next():
            try:
                self.tokenizer = self.reader.readline().split()
            except Exception as e:
                raise RuntimeError(e)
        return self.tokenizer.pop(0)

    def next_int(self):
        return int(self.next())

    def next_long(self):
        return int(self.next())

    def next_double(self):
        return float(self.next())

def solve(sc, pw):
    t = sc.next_int()
    while t > 0:
        n = sc.next_long()
        m = sc.next_long()
        if n == 0:
            pw.write("0\n")
            continue
        if n == m:
            pw.write("0\n")
            continue
        if n > m:
            n = (n + n % m) - m
            pw.write(str(min(m-n, n)) + "\n")
            continue
        pw.write(str(min(m-n, n)) + "\n")
        t -= 1

def main():
    sc = InputReader()
    pw = sys.stdout
    solve(sc, pw)
    pw.flush()

if __name__ == "__main__":
    main()