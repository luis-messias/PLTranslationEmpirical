import sys

class Solution:
    def __init__(self):
        self.N = 0
        self.MOD = 1000000007
        self.TOKENS = ["A", "C", "G", "T"]
        self.memo = {}

    def calc(self):
        return self.dfs(0, "TTT")

    def is_ok(self, last4):
        if "AGC" in last4:
            return False
        for i in range(3):
            vals = list(last4)
            vals[i], vals[i+1] = last4[i+1], last4[i]
            s = "".join(vals)
            if "AGC" in s:
                return False
        return True

    def dfs(self, current, last3):
        if (current, last3) in self.memo:
            return self.memo[(current, last3)]
        if current == self.N:
            return 1
        result = 0
        for c in self.TOKENS:
            if self.is_ok(last3 + c):
                result += self.dfs(current+1, last3[1:] + c)
                result %= self.MOD
        self.memo[(current, last3)] = result
        return result

if __name__ == "__main__":
    ins = Solution()
    ins.N = int(input())
    print(ins.calc())