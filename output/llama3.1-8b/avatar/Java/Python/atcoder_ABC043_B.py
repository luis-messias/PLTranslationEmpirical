import sys
from typing import List

class LightScanner:
    def __init__(self, in_stream):
        self.reader = in_stream

    def string(self) -> str:
        tokens = list(self.reader.readline().split())
        if not tokens:
            try:
                tokens = list(self.reader.readline().split())
            except Exception as e:
                raise Exception(e)
        return tokens[0]

class BUnhappyHackingABCEdit:
    def solve(self, test_number: int, in_scanner: LightScanner, out_stream):
        s = in_scanner.string()
        d = []
        for c in s:
            if c == '0':
                d.append('0')
            elif c == '1':
                d.append('1')
            elif c == 'B':
                if len(d) > 0:
                    d.pop()
        out_stream.write("".join(d))
        out_stream.write("\n")

def main():
    in_stream = sys.stdin
    out_stream = sys.stdout

    in_scanner = LightScanner(in_stream)
    solver = BUnhappyHackingABCEdit()

    solver.solve(1, in_scanner, out_stream)

if __name__ == "__main__":
    main()