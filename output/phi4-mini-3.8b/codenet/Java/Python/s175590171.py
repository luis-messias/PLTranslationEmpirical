import sys

class FastScanner:
    def __init__(self):
        self.buffer = bytearray(1024)
        self.ptr = 0
        self.buflen = len(self.buffer)

    def has_next_byte(self) -> bool:
        if self.ptr < self.buflen:
            return True
        else:
            try:
                while not sys.stdin.readable() and (self.buflen <= 0 or False):
                    pass
                read_bytes = sys.stdin.readinto(memoryview(self.buffer)[self.ptr:])
                if read_bytes == -1: 
                    raise EOFError()
                self.buflen += len(read_bytes)
                return True

    def next_int(self) -> int:
        while not self.has_next_byte():
            raise StopIteration
        result, sign = 0, 1
        start_ptr = self.ptr
        
        if sys.stdin.readable() and (self.buffer[self.ptr] == ord('-')):
            sign = -1
            self.ptr += 1

        for i in range(start_ptr, len(self.buffer)):
            c = chr(self.buffer[i])
            if '0' <= c < '9':
                result *= 10
                result += int(c) * sign
            else:
                break
        
        return result


def main():
    scanner = FastScanner()
    
    n = next(scanner)
    a = [next(scanner) for _ in range(n)]
    a.sort()

    sum, count = 0, 1

    for i in range(len(a)-1):
        if not (a[i+1] <= 2 * sum): 
            break
        else:
            sum += a[i]
    
    print(count + 1)


if __name__ == "__main__":
    main()