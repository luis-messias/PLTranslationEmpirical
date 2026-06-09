import sys

def solve():
    # Read all input from stdin and split it into tokens
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        k = int(data[0])
        n = int(data[1])
    except Exception:
        # Handle case where input might be missing or malformed
        return

    MOD = 998244353
    MAX_N = 4001
    
    # Precompute combinations (nchoosek) using Pascal's identity
    nchoosek = [[0] * MAX_N for _ in range(MAX_N)]
    
    for i in range(MAX_N):
        nchoosek[i][0] = 1
        if i < MAX_N:
            nchoosek[i][i] = 1
        for j in range(1, i):
            nchoosek[i][j] = (nchoosek[i-1][j] + nchoosek[i-1][j-1]) % MOD

    # Main calculation loop
    for i in range(2, 2 * k + 1):
        pairs = 0
        if i > k:
            pairs = k - i // 2
        else:
            pairs = (i - 1) // 2
        
        active = k - 2 * pairs
        if i % 2 == 0:
            active -= 1
        
        times2 = 1
        total = 0
        
        for j in range(pairs + 1):
            # Calculate choice = times2 * nchoosek[pairs][j] % MOD
            choice = (times2 * nchoosek[pairs][j]) % MOD
            
            # Check bounds for combinations
            if active + j - 1 < 0:
                continue
            
            # Term 1: nchoosek[n + active - 1][active + j - 1]
            term1_n = n + active - 1
            term1_k = active + j - 1
            
            if term1_n >= 0 and term1_k >= 0 and term1_n < MAX_N and term1_k < MAX_N:
                term1 = nchoosek[term1_n][term1_k]
                total = (total + choice * term1) % MOD
            
            # Term 2 (if i is even): nchoosek[n + active - 2][active + j - 1]
            if i % 2 == 0:
                term2_n = n + active - 2
                term2_k = active + j - 1
                
                if term2_n >= 0 and term2_k >= 0 and term2_n < MAX_N and term2_k < MAX_N:
                    term2 = nchoosek[term2_n][term2_k]
                    total = (total + choice * term2) % MOD
            
            # Update times2 for the next iteration
            times2 = (times2 * 2) % MOD
        
        print(total)

solve()