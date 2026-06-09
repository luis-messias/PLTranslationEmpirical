import sys
from typing import List

class Scanner:
    def __init__(self):
        self.stdin = sys.stdin

    def next(self):
        return self.stdin.readline().strip()

    def hasNext(self):
        return True

    def nextLine(self):
        return self.next()

class Solution:
    def __init__(self):
        self.scanner = Scanner()

    def run_case(self):
        line = self.scanner.nextLine()
        if line:  # Check if the line is not empty
            N, K = map(int, line.split())
            len_ = 0
            while N > 0:
                N //= K
                len_ += 1

            print(len_)
            return

class LCS:
    def lcs(self, A: str, B: str) -> int:
        sz_a, sz_b = len(A), len(B)
        dp = [[0] * (sz_b + 1) for _ in range(sz_a + 1)]

        for i in range(sz_a + 1):
            dp[i][0] = 0
        for j in range(sz_b + 1):
            dp[0][j] = 0

        for i in range(1, sz_a + 1):
            for j in range(1, sz_b + 1):
                if A[i - 1] == B[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

        return dp[sz_a][sz_b]

    def getLCS(self, X: str, Y: str) -> str:
        m, n = len(X), len(Y)
        index = self.lcs(X, Y)

        lcs = ['\0'] * (index + 1)
        i, j = m, n
        while i > 0 and j > 0:
            if X[i - 1] == Y[j - 1]:
                lcs[index - 1] = X[i - 1]
                i -= 1
                j -= 1
                index -= 1
            elif dp[i - 1][j] > dp[i][j - 1]:
                i -= 1
            else:
                j -= 1

        return ''.join(lcs[:index + 1])

def main():
    solution = Solution()
    while True:
        line = input()
        if not line:  # Exit the loop when an empty line is encountered
            break
        solution.run_case()

if __name__ == "__main__":
    main()
