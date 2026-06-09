import sys
from io import StringIO

class SimpleScanner:
    def __init__(self, in_stream):
        self.in_stream = in_stream
        self.buffer = StringIO()
        self.eof = False

    def read(self):
        if not self.buffer.tell():
            chunk = self.in_stream.read(10240)
            if not chunk:
                self.eof = True
                return ''
            self.buffer.write(chunk)
        return self.buffer.read(1)

    def check_eof(self):
        if self.eof:
            raise StopIteration

    def next_char(self):
        self.check_eof()
        return self.read()

    def next(self):
        while True:
            char = self.next_char()
            if not char.isspace():
                break
        sb = StringIO()
        while True:
            sb.write(char)
            char = self.next_char()
            if char.isspace() or self.eof:
                break
        return sb.getvalue()

    def next_int(self):
        return int(self.next())

    def next_long(self):
        return int(self.next())

def main():
    scanner = SimpleScanner(sys.stdin)
    writer = sys.stdout

    r = scanner.next_int()
    d = scanner.next_int()
    x = scanner.next_long()

    for _ in range(10):
        x = r * x - d
        print(x, file=writer)

if __name__ == "__main__":
    main()