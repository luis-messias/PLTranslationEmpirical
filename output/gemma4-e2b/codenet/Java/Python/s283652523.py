import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first token is N
        N = int(data[0])
        
        if N == 0:
            print(0)
            return
            
        # The remaining tokens are the array A
        A = [int(x) for x in data[1:N+1]]
        
    except (IndexError, ValueError):
        # Handle malformed input if necessary
        return

    MOD = 10**9 + 7
    
    # The calculation logic from the Java code:
    # long ans = 0, sum = A[N-1];
    ans = 0
    
    # sum starts at A[N-1]
    # We must ensure A is not empty, which is guaranteed if N > 0
    sum_val = A[N-1] % MOD
    
    # Loop from N-2 down to 0
    for i in range(N - 2, -1, -1):
        # ans += (sum * A[i]) % MOD;
        term = (sum_val * A[i]) % MOD
        ans = (ans +