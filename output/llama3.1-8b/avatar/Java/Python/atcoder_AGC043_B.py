import sys

class MyScanner:
    def __init__(self):
        self.br = sys.stdin

    def next(self):
        while True:
            try:
                return next(self.st) if self.st else next(self.br).strip()
            except StopIteration:
                self.st = [word for word in self.br.readline().split()]
                if not self.st: raise EOFError

    def ni(self):
        return int(self.next())

    def nl(self):
        return int(self.next())

    def nc(self):
        return self.next()

class atcoder_AGC043_B:
    @staticmethod
    def cal(s, c):
        n = len(s)
        m = n - 1
        ans = 0
        for i in range(n):
            if s[i] == c and (m & i) == i:
                ans ^= 1
        return ans

    def solve(self):
        n = self.sc.ni()
        s = self.sc.next()
        sb = []
        for i in range(1, n):
            sb.append(abs(ord(s[i]) - ord(s[i-1])))
        if n == 2:
            print(sb[0])
            return
        s = ''.join(map(str, sb))
        if '1' in s:
            print(self.cal(s, '1'))
        else:
            print(self.cal(s, '2') * 2)

    def __init__(self):
        self.sc = MyScanner()

if __name__ == "__main__":
    atcoder_AGC043_B().solve()