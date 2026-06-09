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
        return int(next(self.next()))

    def next_long(self):
        return int(next(self.next()))

def main():
    a = input_reader.next_int()
    b = input_reader.next_int()
    c = input_reader.next_int()
    d = input_reader.next_int()

    if c > b:
        print(0)
    elif a > d:
        print(0)
    elif a < c:
        print(min(b, d) - c)
    else:
        l = [a, b, c, d]
        l.sort()
        print(l[2] - l[1])

input_reader = InputReader(sys.stdin)
main()