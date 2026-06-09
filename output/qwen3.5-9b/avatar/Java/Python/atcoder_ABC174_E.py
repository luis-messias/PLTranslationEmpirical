import sys
from io import BytesIO

class InputReader:
    def __init__(self, stream):
        self.stream = stream
        self.buffer = BytesIO(stream.read())
        self.tokenizer = None
    
    def next(self):
        while self.tokenizer is None or not self.tokenizer:
            try:
                line = self.buffer.readline()
                if not line:
                    return None
                self.tokenizer = line.split()
            except:
                return None
        return self.tokenizer[0]
    
    def nextInt(self):
        return int(self.next())
    
    def readArray(self, n):
        return [self.nextInt() for _ in range(n)]

class Solution:
    def solve(self, in_reader, out_writer):
        n = in_reader.nextInt()
        k = in_reader.nextInt()
        logsLength = in_reader.readArray(n)
        
        min_val = 1
        max_val = 10**9 + 1000
        
        while min_val < max_val:
            mid = (min_val + max_val) // 2
            if self.nei(mid, logsLength, k):
                max_val = mid
            else:
                min_val = mid + 1
        
        out_writer.write(str(min_val) + '\n')
    
    def nei(self, mid, logsLength, k):
        for log in logsLength:
            k -= (log + mid - 1) // mid - 1
        return k >= 0

def main():
    input_data = sys.stdin.read()
    input_stream = BytesIO(input_data.encode())
    output_stream = BytesIO()
    
    in_reader = InputReader(input_stream)
    out_writer = output_stream
    
    solution = Solution()
    solution.solve(in_reader, out_writer)
    
    sys.stdout.write(output_stream.getvalue())

if __name__ == "__main__":
    main()