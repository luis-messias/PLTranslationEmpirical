import sys
from typing import List, Tuple

class Solution:
    def __init__(self):
        self.set = set()

    def main(self):
        n = int(input())
        a = list(map(int, input().split()))
        dp = [-1] * (n + 1)
        dp[n - 1] = a[n - 1]
        for i in range(n - 2, -1, -1):
            dp[i] = max(dp[i + 1], a[i])
        result = []
        for i in range(n):
            if a[i] > dp[i + 1]:
                result.append(0)
            else:
                result.append(dp[i + 1] - a[i] + 1)
        print(*result)

if __name__ == "__main__":
    solution = Solution()
    solution.main()