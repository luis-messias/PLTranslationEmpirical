import sys

def power(x, n, mod):
    res = 1
    x %= mod
    while n > 0:
        if n % 2 == 1:
            res = (res * x) % mod
        x = (x * x) % mod
        n //= 2
    return res

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    try:
        n = int(data[0])
    except ValueError:
        return

    # C array elements start from the second token
    if n > 0:
        try:
            c = [int(x) for x in data[1:n+1]]
        except ValueError:
            return
    else:
        c = []

    MOD = 1000000007

    if n == 1:
        print((c[0] * 2) % MOD)
        return

    # Sort the array c (equivalent to Arrays.parallelSort)
    c.sort()

    # Calculate b = 2^n mod MOD
    b = power(2, n, MOD)

    # Calculate a = 2^(n-2) mod MOD
    a = power(2, n - 2, MOD)

    ans = 0

    # Loop from i = 2 to n + 1
    for i in range(2, n + 2):
        # Calculate val = (a * i) * c[n + 1 - i] mod MOD
        
        # Index for c: n + 1 - i
        # When i=2, index is n-1 (c[n-1])
        # When i=n+1, index is 0 (c[0])
        c_index = n + 1 - i
        
        # Since c is sorted, c[0] is the smallest, c[n-1] is the largest.
        # The Java code uses c[n + 1 - i].
        # i=2 -> c[n-1] (largest element)
        # i=n+1 -> c[0] (smallest element)
        
        val = (a * i) % MOD
        val = (val * c[c_index]) % MOD
        
        ans = (ans + val) % MOD

    # Final result = ans * b mod MOD
    ans = (ans * b) % MOD
    
    print(ans)

if __name__ == "__main__":
    solve()