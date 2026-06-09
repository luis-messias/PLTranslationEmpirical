import sys
input = sys.stdin.readline

class InputReader:
    def __init__(self):
        self.tokenizer = None

    def next(self):
        while self.tokenizer == None or not self.tokenizer.hasMoreTokens():
            try:
                self.tokenizer = self.reader.tokenize(self.reader.readLine())
            except Exception as e:
                raise RuntimeError(e)
        return self.tokenizer.nextToken()

    def nextInt(self):
        return int(self.next())

    def readArray(self, n):
        a = []
        for i in range(n):
            a.append(self.nextInt())
        return a

class Solution:
    def __init__(self, inputReader):
        self.inputReader = inputReader
        self.reader = sys.stdin

    def solve(self):
        n = self.inputReader.nextInt()
        k = self.inputReader.nextInt()
        logsLength = self.inputReader.readArray(n)
        min_val = 1
        max_val = int(1e9) + 1000
        while min_val < max_val:
            mid = (min_val + max_val) // 2
            if self.nei(mid, logsLength, k):
                max_val = mid
            else:
                min_val = mid + 1
        print(min_val)

    def nei(self, mid, logsLength, k):
        for log in logsLength:
            k -= (log + mid - 1) // mid - 1
        return k >= 0

def main():
    inputReader = InputReader()
    solution = Solution(inputReader)
    n = int(input())
    k = int(input())
    logsLength = list(map(int, input().split()))[:n]
    solution.solve()

if __name__ == "__main__":
    main()
