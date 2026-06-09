import sys

sys.setrecursionlimit(10000)

dp = []
mod = 1000000007

def dfs(s):
    if dp[s] != -1:
        return dp[s]
    
    ret = 0
    for i in range(s - 3, -1):
        ret += dfs(i)
        ret %= mod
    
    dp[s] = ret
    return ret

def main():
    s = int(input())
    dp = [-1] * (s + 1)
    dp[0] = 1
    print(dfs(s))

if __name__ == "__main__":
    main()
