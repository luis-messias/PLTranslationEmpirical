import sys

class InputReader:
    def __init__(self, stream):
        self.reader = stream

    def next(self):
        while True:
            line = self.reader.readline()
            if not line:
                return None
            tokens = line.split()
            for token in tokens:
                yield token.strip()

    def next_int(self):
        try:
            return int(next(self.next()))
        except StopIteration:
            return None

    def next_long(self):
        try:
            return int(next(self.next()))
        except StopIteration:
            return None

def main():
    input_reader = InputReader(sys.stdin)
    a = input_reader.next_int()
    b = input_reader.next_int()
    c = input_reader.next_int()
    d = input_reader.next_int()

    if c > b or (a is not None and a > d):
        print(0)
    elif a is not None and a < c:
        print(min(b, d) - c)
    else:
        l = [a, b, c, d]
        l.sort()
        print(l[2] - l[1])

main()
