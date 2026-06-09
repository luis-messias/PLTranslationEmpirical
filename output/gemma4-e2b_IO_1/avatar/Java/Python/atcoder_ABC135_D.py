import sys

def solve():
    # Read the input sequence from stdin
    try:
        # Read the entire input as a single string
        input_data = sys.stdin.read().strip()
    except:
        # Handle case where input might be empty or error occurs
        return

    if not input_data:
        return

    cs = list(input_data)
    L = len(cs)
    MOD = 10**9 + 7

    # dp[i][j]
    # i: index (0 to L-1)
    # j: state (0 to 12)
    # Initialize dp table
    dp = [[0] * 13 for _ in range(L)]

    base = 1

    # Iterate backwards through the input string
    for i in range(L):
        # The character being processed is cs[L - 1 - i]
        char_index = L - 1 - i
        char = cs[char_index]

        if char == '?':
            # Case: Wildcard '?'
            for pre in range(13):
                for next_digit in range(10):
                    # Index calculation: (base * next + pre) % 13
                    idx = (base * next_digit + pre) % 13

                    # Value to add: dp[i - 1][pre] or (pre == 0 ? 1 : 0)
                    if i > 0:
                        value_to_add = dp[i - 1][pre]
                    else:
                        value_to_add = 1 if pre == 0 else 0

                    dp[i][idx] = (dp[i][idx] + value_to_add) % MOD

        else:
            # Case: Digit
            next_digit = int(char)
            for pre in range(13):
                # Index calculation: (base * next + pre) % 13
                idx = (base * next_digit + pre) % 13

                # Value to add: dp[i - 1][pre] or (pre == 0 ? 1 : 0)
                if i > 0:
                    value_to_add = dp[i - 1][pre]
                else:
                    value_to_add = 1 if pre == 0 else 0

                dp[i][idx] = (dp[i][idx] + value_to_add) % MOD

        # Update base
