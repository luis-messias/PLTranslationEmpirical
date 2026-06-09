import sys

def solve():
    # Read input from stdin
    try:
        S = sys.stdin.read().strip()
    except:
        return

    if not S:
        return

    MOD = 1000000007
    N = len(S)

    # dp[i][j] stores the number of ways to form the prefix S[0...i-1] such that the number formed is congruent to j mod 13.
    # We need N+1 rows and 13 columns.
    dp = [[0] * 13 for _ in range(N + 1)]

    # Base case: Empty prefix (length 0) results in value 0 mod 13, 1 way.
    dp[0][0] = 1

    for i in range(N):
        # Current character S[i]
        current_char = S[i]
        
        # Iterate over previous states k (mod 13)
        for k in range(13):
            if dp[i][k] == 0:
                continue
            
            count = dp[i][k]
            
            if current_char == '?':
                # If it's '?', we can append digits j = 0 to 9
                for j in range(10):
                    new_mod = (k * 10 + j) % 13
                    dp[i + 1][new_mod] = (dp[i + 1][new_mod] + count) % MOD
            else:
                # If it's a digit x
                x = int(current_char)
                new_mod = (k * 10 + x) % 13
                dp[i + 1][new_mod] = (dp[i + 1][new_mod] + count) % MOD

    # The result is the total count for the full string S, ending in state 5.
    print(dp[N][5])

solve()
