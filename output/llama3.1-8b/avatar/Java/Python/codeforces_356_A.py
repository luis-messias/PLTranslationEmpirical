from typing import List
import sys

class FastReader:
    def __init__(self):
        self.st = None

    def next(self):
        while not self.st or not self.st.hasMoreTokens():
            try:
                self.st = self.br.nextToken()
            except Exception as e:
                print(e)
        return self.st.nextToken()

    def nextInt(self):
        return int(self.next())

    def nextLong(self):
        return int(self.next())

    def nextDouble(self):
        return float(self.next())

    def nextLine(self):
        s = ""
        while self.st and self.st.hasMoreTokens():
            try:
                s += self.st.nextToken() + " "
            except Exception as e:
                print(e)
        return s

class codeforces_356_A:
    def __init__(self):
        self.inp = FastReader()

    def solve(self):
        n = self.inp.nextInt()
        left = set(range(n))
        answer = [0] * n
        for i in range(q):
            l, r, win = self.inp.nextInt() - 1, self.inp.nextInt() - 1, self.inp.nextInt()
            while True:
                curr = max(left) if l <= max(left) else min(left)
                if curr > r:
                    break
                answer[curr] = win
                left.remove(curr)
            answer[win - 1] = 0
            left.add(win - 1)

        ans = ""
        for i in range(n):
            ans += str(answer[i]) + " "
        print(ans.strip())

if __name__ == "__main__":
    codeforces_356_A().solve()