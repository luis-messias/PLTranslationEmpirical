import sys

MOD = int(1e9 + 7)

class Atcoder_ABC135_D:
    def __init__(self):
        self.cs = None
        self.dp = None

    def run(self):
        sc = input()
        self.cs = list(sc)
        self.dp = [[0] * 13 for _ in range(len(self.cs))]
        base = 1
        for i in range(len(self.cs)):
            if self.cs[-i - 1] == '?':
                for pre in range(13):
                    for next_digit in range(10):
                        index = (base * next_digit + pre) % 13
                        self.dp[i][index] += (i > 0 and self.dp[i-1][pre]) or (pre == 0)
                        self.dp[i][index] %= MOD
            else:
                next_digit = ord(self.cs[-i - 1]) - ord('0')
                for pre in range(13):
                    index = (base * next_digit + pre) % 13
                    self.dp[i][index] += (i > 0 and self.dp[i-1][pre]) or (pre == 0)
                    self.dp[i][index] %= MOD
            base = (base * 10) % 13

        print(self.dp[-1][5])

if __name__ == "__main__":
    atcoder_ABC135_D = Atcoder_ABC135_D()
    atcoder_ABC135_D.run()