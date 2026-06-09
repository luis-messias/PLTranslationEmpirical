import sys

def solve():
    # Read input string Si
    try:
        si = sys.stdin.readline().strip()
    except EOFError:
        return

    if not si:
        return

    # Reverse the string and convert to a list of characters (S)
    S = list(si[::-1])

    # DP array initialization
    # dp[j] stores the count for state j
    dp = [0] * 13
    dp[0] = 1

    MOD = 1000000007

    # d tracks the power of 10 modulo 13
    d = 1

    for i in range(len(S)):
        c = S[i]
        
        # Create the next DP state array
        nd = [0] * 13

        if c.isdigit():
            # Case 1: Character is a digit
            digit_val = int(c)
            x = digit_val * d

            # Transition: Shift/copy dp[j] to nd[(j + x) % 13]
            for j in range(13):
                nd[(j + x) % 13] = dp[j]
        else:
            # Case 2: Character is not a digit
            for xi in range(10):
                x = xi * d

                # Transition: Sum contributions
                for j in range(13):
                    ni = (j + x) % 13
                    nd[ni] = (nd[ni] + dp[j]) % MOD

        # Update dp state
        dp = nd
        
        # Update d for the next iteration: d = d * 10 % 13
        d = (d * 10) % 13

    # Output the result stored in dp[5]
    print(dp[5])

if __name__ == "__main__":
    solve()