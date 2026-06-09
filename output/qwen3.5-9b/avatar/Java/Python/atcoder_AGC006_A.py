import sys
from io import StringIO

class InputReader:
    def __init__(self, stream):
        self.reader = stream
        self.tokenizer = None
    
    def next(self):
        while self.tokenizer is None or not self.tokenizer:
            try:
                line = self.reader.readline()
                if not line:
                    return None
                self.tokenizer = line.split()
            except:
                return None
        return self.tokenizer.pop(0)
    
    def nextInt(self):
        return int(self.next())

def getFail(b, m):
    j = 0
    f = [0] * (m + 1)
    for i in range(2, m + 1):
        while j > 0 and b[j] != b[i]:
            j = f[j]
        if b[j] == b[i]:
            j += 1
        f[i] = j
    return f

def main():
    in_reader = InputReader(sys.stdin)
    n = in_reader.nextInt()
    s1 = in_reader.next()
    str = in_reader.next()
    
    b = [0] * (2 * n + 1)
    cnt = 0
    for i in range(n):
        b[cnt + 1] = str[i]
        cnt += 1
    for i in range(n):
        b[cnt + 1] = s1[i]
        cnt += 1
    
    f = getFail(b, cnt)
    length = min(f[cnt], min(n, n))
    print(2 * n - length)

if __name__ == "__main__":
    main()