import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if len(data) < 4:
        return

    A = int(data[0])
    B = int(data[1])
    C = int(data[2])
    D = int(data[3])

    MOD = 998244353

    # Initialize DP table. Dimensions up to C and D.
    # We need indices up to C and D.
    dp = [[0] * (D + 1) for _ in range(C + 1)]

    # Base case: dp[A][B] = 1
    if A <= C and B <= D:
        dp[A][B] = 1

    # Fill the DP table
    for c in range(A, C + 1):
        for d in range(B, D + 1):
            if c == A and d == B:
                continue
            
            ans = 0
            
            # Term 1: c > A
            if c > A:
                # part = dp[c - 1][d]
                part = dp[c - 1][d]
                # ans = part * d
                ans = (part * d)
            
            # Term 2: d > B
            if d > B:
                # part = dp[c][d - 1]
                part = dp[c][d - 1
