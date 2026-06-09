import sys

def solve():
    # Read input s
    try:
        # Read all input and strip whitespace
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        s = int(input_data)
    except EOFError:
        return
    except ValueError:
        return

    MOD = 1000000007
    
    # Initialize DP array (size s + 1)
    # dp[i] stores the result for input i
    dp = [-1] * (s + 1)
    dp[0] = 1

    def dfs(current_s):
        # Check memoization
        if dp[current_s] != -1:
            return dp[current_s]

        ret = 0
        # Loop from current_s - 3 down to 0 (inclusive)
        # range(start, stop, step)
        for i in range(current_s - 3, -1, -1):
            ret = (ret + dfs(i)) % MOD
        
        # Store and return result
        dp[current_s] = ret
        return ret

    result = dfs(s)
    print(result)

if __name__ == "__main__":
    solve()