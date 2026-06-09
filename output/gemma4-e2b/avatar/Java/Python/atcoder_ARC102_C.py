import sys

def solve():
    # Set recursion limit higher for safety, although this solution is iterative
    # sys.setrecursionlimit(2000)

    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # The input format seems to be k and n on separate lines or space separated.
    # Based on the Java code reading nextInt() twice, we expect k and n.
    if len(data) < 2:
        return

    k = int(data[0])
    n = int(data[1])

    mod = 998244353

    # Precompute nchoosek (Binomial coefficients) up to 4000
    N_MAX = 4001
    nchoosek = [[0] * N_MAX for _ in range(N_MAX)]

    for i in range(N_MAX):
        nchoosek[i][0] = 1
        if i < N_MAX:
            nchoosek[i][i] = 1

    for i in range(2, N_MAX):
        for j in range(1, i):
            nchoosek[i][j] = (nchoosek[i - 1][j] + nchoosek[i - 1][j - 1]) % mod

    # Main calculation logic
    
    # The loop runs from i = 2 to 2 * k
    for i in range(2, 2 * k + 1):
        # Determine pairs
        if i > k:
            pairs = k - i // 2
        else:
            pairs = (i - 1) // 2
        
        active = k - 2 * pairs
        
        if i % 2 == 0:
            active -= 1
            
        times2 = 1
        total = 0
        
        # Loop over j from 0 to pairs
        for j in range(pairs + 1):
            # choice = times2 * nchoosek[pairs][j] % mod
            choice = (times2 * nchoosek[pairs][j]) % mod
            
            # times2 = times2 * 2 % mod
            times2 = (times2 * 2) % mod
            
            # Check index validity
            if active + j - 1 < 0:
                continue
            
            # total += choice * nchoosek[n + active - 1][active + j - 1]
            
            # Note: Java uses n + active - 1 and active + j - 1 as indices.
            # Since n and k are up to 4000, n + active - 1 might exceed 4000 if n is large, 
            # but the precomputed table size is 4001x4001. We must assume the indices fit within the precomputed bounds.
            
            # We need to ensure indices are within bounds [0, 4000] for nchoosek[n][k]
            n_idx = n + active - 1
            k_idx = active + j - 1
            
            if n_idx >= N_MAX or k_idx >= N_MAX or k_idx < 0:
                # This case should ideally not happen if the problem constraints respect the precomputation size
                continue

            term = (choice * nchoosek[n_idx][k_idx]) % mod
            total = (total + term) % mod

            # If i is even, add the second term
            if i % 2 == 0:
                # total += choice * nchoosek[n + active - 2][active + j - 1]
                n_idx_2 = n + active - 2
                k_idx_2 = active + j - 1
                
                if n_idx_2 >= N_MAX or k_idx_2 >= N_MAX or k_idx_2 < 0:
                    continue
                    
                term2 = (choice * nchoosek[n_idx_2][k_idx_2]) % mod
                total = (total + term2) % mod

    print(total)

solve()