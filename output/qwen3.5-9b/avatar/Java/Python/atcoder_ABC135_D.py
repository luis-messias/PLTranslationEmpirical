import sys

class atcoder_ABC135_D:
    def __init__(self):
        self.MOD = 10**9 + 7
    
    def run(self):
        cs = input()
        n = len(cs)
        dp = [[0] * 13 for _ in range(n)]
        base = 1
        
        for i in range(n):
            if cs[n - 1 - i] == '?':
                for pre in range(13):
                    for next in range(10):
                        new_rem = (base * next + pre) % 13
                        if i > 0:
                            dp[i][new_rem] += dp[i - 1][pre]
                        else:
                            if pre == 0:
                                dp[i][new_rem] += 1
                        dp[i][new_rem] %= self.MOD
            else:
                next = int(cs[n - 1 - i])
                for pre in range(13):
                    new_rem = (base * next + pre) % 13
                    if i > 0:
                        dp[i][new_rem] += dp[i - 1][pre]
                    else:
                        if pre == 0:
                            dp[i][new_rem] += 1
                    dp[i][new_rem] %= self.MOD
            base = (base * 10) % 13
        
        print(dp[n - 1][5])

if __name__ == "__main__":
    atcoder_ABC135_D().run()