import sys
from collections import deque

class InputReader:
    def __init__(self, stream):
        self.reader = stream
        self.tokenizer = None

    def next(self):
        while not self.tokenizer or not self.tokenizer[0]:
            try:
                self.tokenizer = list(next(self.reader).split())
            except StopIteration:
                return None
        return self.tokenizer.pop(0)

class TaskD:
    def solve(self, test_number, in_reader, out_writer):
        S = in_reader.next()
        score = 0
        for i in range(len(S)):
            my = 'g' if i % 2 == 0 else 'p'
            his = S[i]
            if my != his:
                score += 1 if my == 'p' else -1
        out_writer.write(str(score) + '\n')

def main():
    input_stream = sys.stdin
    output_stream = sys.stdout
    in_reader = InputReader(input_stream)
    out_writer = sys.stdout.write
    task_d_solver = TaskD()
    task_d_solver.solve(1, in_reader, out_writer)

if __name__ == "__main__":
    main()