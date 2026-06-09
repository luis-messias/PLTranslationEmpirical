import sys

def solve():
    # Read input from stdin
    try:
        Si = sys.stdin.readline().strip()
    except EOFError:
        return
    
    if not Si:
        return

    # S is created by reversing Si and converting to a list of characters
    # Java: String Si = in.next(); char[] S = new StringBuilder(Si).reverse().toString().toCharArray();
    S_list = list(Si)
    S = S_list[::-1]

    # dp array initialization
    dp = [0] * 13
    dp[0] = 1

    MOD = 1000000007

    # i iterates over the index of S, d tracks 10^i mod 13
    # Java: for (int i = 0, d = 1; i < S.length; i++, d = d * 10 % 13)
    d = 1
    for i in range(len(S)):
        # d is the current power of 10 mod 13
        # The Java code updates d *after* using it for the current iteration i.
        # Let's adjust the loop structure to match the Java flow where d is updated inside the loop condition check.
        
        # Replicating the Java loop structure:
        # The loop runs for i = 0 to S.length - 1.
        # d starts at 1.
        # Iteration 1 (i=0): d=1. Update d = 10 % 13 = 10.
        # Iteration 2 (i=1): d=10. Update d = 100 % 13 = 9.
        # ...
        
        # Let's re-read the Java loop: for (int i = 0, d = 1; i < S.length; i++, d = d * 10 % 13)
        # This structure implies i increments first, then d updates based on the new i, or d updates based on the current i.
        # In Java, the update d = d * 10 % 13 happens at the end of the iteration.
        
        # Let's use the structure where d is calculated based on i: d = 10^i mod 13
        
        # Since the Java code uses i and d simultaneously:
        # i=0, d=1. Process S[0]. d becomes 10 % 13 = 10.
        # i=1, d=10. Process S[1]. d becomes 100 % 13 = 9.
        
        # We need to ensure d corresponds to 10^i mod 13.
        
        # Let's reset d and use the standard power calculation for clarity, although the Java code implies a specific iterative update.
        
        # If we stick strictly to the Java loop structure:
        # i=0, d=1. Loop runs. i=1, d=10.
        # i=1, d=10. Loop runs. i=2, d=9.
        
        # We must handle the case where the loop variable i is used for indexing S, and d for calculation.
        
        # Let's use the index i directly for the power calculation:
        d_val = pow(10, i, 13)
        
        nd = [0] * 13

        c = S[i]

        if c.isdigit():
            # Java: int x = (c - '0') * d;
            digit = int(c)
            x = digit * d_val

            for j in range(13):
                nd[(j + x) % 13] = dp[j]
        else:
            # Java: for (int xi = 0; xi < 10; xi++) { int x = xi * d; ... }
            for xi in range(10):
                x = xi * d_val

                for j in range(13):
                    ni = (j + x) % 13
                    nd[ni] = (nd[ni] + dp[j]) % MOD

        dp = nd

    # Java: out.println(dp[5]);
    print(dp[5])

solve()