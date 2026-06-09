import sys

def solve():
    # Read the input string S (equivalent to sc.next() in Java)
    try:
        S = sys.stdin.read().strip()
    except:
        # Fallback for environments where sys.stdin.read() might fail
        S = input().strip()

    if not S:
        return

    MOD = 1000000007
    N = len(S)
    
    # dp[i][j]: count of ways to form prefix of length i with remainder j mod 13
    # Dimensions: (N+1) x 13
    dp = [[0] * 13 for _ in range(N + 1)]

    # Initialization: Empty prefix (length 0) has remainder 0, 1 way.
    dp[0][0] = 1

    for i in range(N):
        char = S[i]
        
        if char == '?':
            # Wildcard case: try digits 0 through 9
            for j in range(10): # j is the digit
                for k in range(13): # k is the previous remainder
                    if dp[i][k] > 0:
                        new_remainder = (k * 10 + j) % 13
                        dp[i + 1][new_remainder] = (dp[i + 1][new_remainder] + dp[i][k]) % MOD
        else:
            # Digit case
            x = int(char) # x is the digit
            for k in range(13): # k is the previous remainder
                if dp[i][k] > 0:
                    new_remainder = (k * 10 + x) % 13
                    dp[i + 1][new_remainder] = (dp[i + 1][new_remainder] + dp[i][k]) % MOD

    # Output dp[S.length()][5] as per the original Java code
    print(dp[N][5])

solve()