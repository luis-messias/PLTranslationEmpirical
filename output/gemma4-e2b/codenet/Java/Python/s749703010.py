import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # The first element is n
    n = int(data[0])
    
    # The next 2*n elements are the arrays a[0] and a[1]
    a = []
    data_idx = 1
    
    # Read array a[0]
    a0 = [int(x) for x in data[data_idx : data_idx + n]]
    a.append(a0)
    data_idx += n
    
    # Read array a[1]
    a1 = [int(x) for x in data[data_idx : data_idx + n]]
    a.append(a1)

    # Initialize memoization table
    # memo[fliped][idx][msk]
    # fliped: 0 or 1
    # idx: 0 to n (n+1 states)
    # msk: 0 to 2^n - 1
    
    # Initialize with -1 (or a value indicating uncomputed)
    memo = [[[-1] * (1 << n) for _ in range(n + 1)] for _ in range(2)]

    # DP function
    def dp(fliped, idx, msk):
        if msk == (1 << n) - 1:
            return 0
        if memo[fliped][idx][msk] != -1:
            return memo[fliped][idx][msk]
        
        # x = Integer.bitCount(msk)
        x = bin(msk).count('1')
        
        ff = 0  # Counter for unchosen elements
        ans = float('inf')
        
        # Iterate through potential indices i
        for i in range(n):
            if not (msk & (1 << i)):  # If element i is not yet chosen
                nf = x % 2
                
                # Check the condition: a[fliped][idx] <= a[(nf + ff % 2) % 2][i]
                # Note: The Java code uses (nf + (ff % 2)) % 2. Since ff is incremented inside the loop, 
                # we need to be careful about how ff relates to the state.
                
                # In the Java code, ff is the count of elements skipped before reaching i.
                # The logic seems to rely on the parity of the number of elements already processed/skipped.
                
                # Let's stick to the Java logic structure:
                # The index into the second array depends on the parity of (nf + ff % 2).
                
                # Since ff is the count of elements skipped *before* considering i, 
                # the index into the second array is determined by the parity of the total number of elements 
                # considered so far (which is related to x and ff).
                
                # Replicating the Java calculation:
                # The index into the second array is (nf + (ff % 2)) % 2.
                
                if idx == n or a[fliped][idx] <= a[(nf + (ff % 2)) % 2][i]:
                    # Recursive call: next state is (nf + ff % 2, i, msk | 1 << i)
                    result = dp((nf + (ff % 2)) % 2, i, msk | (1 << i))
                    ans = min(ans, ff + result)
                
                ff += 1
            else:
                # If element i is already chosen (msk & (1 << i) is true)
                x -= 1
        
        memo[fliped][idx][msk] = ans
        return ans

    # Start DP from dp(0, n, 0)
    ans = dp(0, n, 0)
    
    # Output result
    if ans >= 1e8:
        print(-1)
    else:
        print(ans)

solve()