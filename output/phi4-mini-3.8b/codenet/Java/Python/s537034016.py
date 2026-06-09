s = int(input())
dp = [-1 for _ in range(s + 1)]
mod = 1000000007

def dfs(s):
    if dp[s] != -1:
        return dp[s]
    
    ret = 0
    for i in range(s - 3, -1, -1):
        ret += dfs(i)
        ret %= mod
    
    dp[s] = ret
    return ret


if __name__ == "__main__":
    print(dfs(2))