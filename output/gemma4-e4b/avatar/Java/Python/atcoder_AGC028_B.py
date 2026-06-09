import sys

def modinv(a, m):
    # Since m = 1000000007 is prime, we use Fermat's Little Theorem: a^(m-2) mod m
    return pow(a, m - 2, m)

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # N is the first element
    n = int(input_data[0])
    
    # A are the remaining elements
    a = [int(x) for x in input_data[1:n+1]]

    mod = 1000000007

    # 1. Calculate P = N! mod mod
    p = 1
    for i in range(2, n + 1):
        p = (p * i) % mod

    # 2. Calculate Q array
    # Q[i] = sum_{k=1}^{i+1} k^{-1} mod mod
    q = [0] * n
    
    # Q[0] = 1 (sum up to k=1)
    q[0] = 1
    
    for i in range(1, n):
        # We need the inverse of (i + 1)
        inv_i_plus_1 = modinv(i + 1, mod)
        q[i] = (q[i - 1] + inv_i_plus_1) % mod

    # 3. Calculate the final answer
    ans = 0
    for i in range(n):
        # val = Q[i] + Q[n - i - 1] - 1
        # Ensure positive result before modulo operations
        val_term = (q[i] + q[n - i - 1] - 1 + mod) % mod
        
        # val = val * A[i]
        val = (val_term * a[i]) % mod
        
        # val = val * P
        val = (val * p) % mod
        
        # ans += val
        ans = (ans + val) % mod

    print(ans)

if __name__ == "__main__":
    solve()