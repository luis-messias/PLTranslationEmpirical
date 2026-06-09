import sys

mod = 1000000007

def main():
    s = int(input())
    dp = [-1]*(s + 1)
    dp[0] = 1
    print(dfs(s))

def dfs(s):
    if dp[s] != -1:
        return dp[s]
    ret = 0
    for i in range(max(0, s-3), s):
        ret += dfs(i)
        ret %= mod
    dp[s] = ret
    return ret

if __name__ == "__main__":
    main()
