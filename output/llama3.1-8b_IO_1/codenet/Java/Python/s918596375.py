import sys
from math import gcd

class FastScanner:
    def __init__(self, in_):
        self.reader = in_
        self.tokenizer = None

    def next(self):
        if not self.tokenizer or not self.tokenizer.has_next():
            try:
                self.tokenizer = self.reader.readline().split()
            except Exception as e:
                raise RuntimeError(e)
        return self.tokenizer.pop(0)

    def next_line(self):
        if not self.tokenizer or not self.tokenizer.has_next():
            try:
                return self.reader.readline().strip()
            except Exception as e:
                raise RuntimeError(e)
        else:
            return ' '.join(self.tokenizer)

    def next_int(self):
        return int(self.next())

    def next_long(self):
        return int(self.next())

def solve(sc, out):
    s = sc.next()

    a = ["a","e","i","o","u"]
    
    for str_ in a:
        if str_.lower() == s.lower():
            print("vowel", file=out)
            return

    print("consonant", file=out)

def main():
    sc = FastScanner(sys.stdin)
    out = sys.stdout

    solve(sc, out)

    out.flush()

if __name__ == "__main__":
    main()
