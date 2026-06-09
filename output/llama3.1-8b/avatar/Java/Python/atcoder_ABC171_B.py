import sys
from typing import List

class InputReader:
    def __init__(self, stream):
        self.reader = stream
        self.tokenizer = None

    def next(self):
        while not self.tokenizer or not self.tokenizer.has_more_tokens():
            try:
                self.tokenizer = self.reader.readline().split()
            except Exception as e:
                raise RuntimeError(e)
        return self.tokenizer.pop(0)

    def ni(self):
        return int(self.next())

class Solution:
    def solve(self, in_reader: InputReader, out):
        n = in_reader.ni()
        k = in_reader.ni()
        a = [in_reader.ni() for _ in range(n)]
        a.sort()
        ans = sum(a[:k])
        print(ans)

def main():
    input_stream = sys.stdin
    output_stream = sys.stdout

    in_reader = InputReader(input_stream)
    out = sys.stdout

    solution = Solution()
    solution.solve(in_reader, out)

if __name__ == "__main__":
    main()